package com.example.metamask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.databinding.BottomDialogBinding
import com.example.metamask.databinding.BottomSwapBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SwapBottomdialog(var adapter: SwapBottomdialogAdapter): BottomSheetDialogFragment() {
    private lateinit var binding: BottomSwapBinding

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




    }


}


data class BottomDialogItem(var name:String)
class SwapBottomdialogAdapter : RecyclerView.Adapter<SwapBottomdialogAdapter.Holder>() {
    private var itemList: MutableList<BottomDialogItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.network_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]



        holder.bind(item)
    }

    fun setItem(items: MutableList<BottomDialogItem>) {
        if (!items.isNullOrEmpty()) {
            itemList = items
            notifyDataSetChanged()
        }
    }

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: BottomDialogItem) {
            view.findViewById<TextView>(R.id.tv_netName).text = item.name

            view.setOnClickListener(View.OnClickListener {
                view.findViewById<TextView>(R.id.coin_select1).text = item.name

            })

        }
    }


}
