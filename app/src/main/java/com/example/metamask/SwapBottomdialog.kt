package com.example.metamask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.databinding.BottomDialogBinding
import com.example.metamask.databinding.BottomSwapBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SwapBottomdialog(var adapter: SwapBottomdialogAdapter): BottomSheetDialogFragment() {
    private lateinit var binding: BottomSwapBinding
    private lateinit var searchView: SearchView
    private var itemList: MutableList<BottomDialogItem> = ArrayList()
    private var filterList: MutableList<BottomDialogItem> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSwapBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView1.adapter = adapter
        Log.d("1234", "attached")

        //검색 기능
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                // 검색 버튼 누를 때 호출

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

      //           검색창에서 글자가 변경이 일어날 때마다 호출
                filterList.clear()
                if (newText != null) {
                    ( 0 until itemList.size)?.filter{
                        itemList[it].toString().toLowerCase().contains(newText.toLowerCase())
                    }?.mapTo(filterList) { itemList[it] }
                }

                var adapter1 = SwapBottomdialogAdapter()
                adapter1.setItem(filterList)
                return true
            }
        })


//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//
//
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//
////                filterList.clear()
////                ( 0 until itemList.size)?.filter{
////                    itemList[it].toString().toLowerCase().contains(newText.toLowerCase())
////                }?.mapTo(filterList) { itemList[it] }
////
////                var adapter1 = SwapBottomdialogAdapter()
////                adapter1.setItem(filterList)
//                return false
//            }
//        })

    }


}


data class BottomDialogItem(var name:String)
class SwapBottomdialogAdapter : RecyclerView.Adapter<SwapBottomdialogAdapter.Holder>() {
    private var itemList: MutableList<BottomDialogItem> = ArrayList()
    private var filterList: MutableList<BottomDialogItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.network_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]


        holder.view.setOnClickListener(View.OnClickListener {

        })


        holder.bind(item)
    }

    fun setItem(items: MutableList<BottomDialogItem>) {
       // if (!items.isNullOrEmpty()) {
            itemList = items
            notifyDataSetChanged()
        //}
    }

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: BottomDialogItem) {
            view.findViewById<TextView>(R.id.tv_netName).text = item.name



        }
    }



}
