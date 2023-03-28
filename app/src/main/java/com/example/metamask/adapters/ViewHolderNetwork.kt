package com.example.metamask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.R

class ViewHolderNetwork(val itemList: ArrayList<String>) :
    RecyclerView.Adapter<ViewHolderNetwork.BoardViewHolderNet>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolderNet {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item, parent, false)
        return BoardViewHolderNet(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolderNet, position: Int) {
        TODO("Not yet implemented")
        holder.tv_netName.text = itemList[position]
    }



    override fun getItemCount(): Int {
        return itemList.count()
    }


    inner class BoardViewHolderNet(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_netName = itemView.findViewById<TextView>(R.id.tv_netName)
    }
}