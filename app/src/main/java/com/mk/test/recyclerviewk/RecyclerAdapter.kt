package com.mk.test.recyclerviewk

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(val items : ArrayList<Image>, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>()  {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageUrl : String = items.get(position).imageUrl
        Glide
            .with(context)
            .load(imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into((holder?.tvItemImageUrl))

        holder?.tvItemName?.text = items.get(position).name
        holder?.tvItemDescription?.text = items.get(position).description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_row, parent, false))
    }

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvItemImageUrl = view.itemImage
        val tvItemName = view.itemName
        val tvItemDescription = view.itemDescription
    }
}