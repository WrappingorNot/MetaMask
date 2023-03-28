package com.example.metamask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.metamask.R
import com.example.metamask.dataclasses.Dataclass

class ViewHolder(val itemList: ArrayList<Dataclass>) :
    RecyclerView.Adapter<ViewHolder.BoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.tv_coin.text = itemList[position].eth
        holder.tv_money.text = itemList[position].money
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }


    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_coin = itemView.findViewById<TextView>(R.id.tv_coin)
        val tv_money = itemView.findViewById<TextView>(R.id.tv_money)
    }
}