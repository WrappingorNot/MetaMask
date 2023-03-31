package com.example.metamask.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.BottomDialogItem
import com.example.metamask.R
import com.example.metamask.dataclasses.netData

class ViewHolderNetwork(var itemList: ArrayList<netData>) :
    RecyclerView.Adapter<ViewHolderNetwork.BoardViewHolderNet>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolderNet {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.network_item, parent, false)
        return BoardViewHolderNet(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolderNet, position: Int) {
        TODO("Not yet implemented")
        holder.tv_netName.text = itemList[position].name
    }


    fun setItem(items: ArrayList<netData>) {
        // if (!items.isNullOrEmpty()) {
        itemList = items
        notifyDataSetChanged()
        //}
    }
    override fun getItemCount(): Int {
        Log.d("size", itemList.count().toString())
        return itemList.size
    }


    inner class BoardViewHolderNet(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_netName = itemView.findViewById<TextView>(R.id.tv_netName)
    }
}