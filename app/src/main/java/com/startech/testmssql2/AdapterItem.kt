package com.startech.testmssql2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_view_items.view.*

class AdapterItem(val arrayList: ArrayList<ModelItem>): RecyclerView.Adapter<AdapterItem.ViewHolder>(){
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
            fun bindItem(modelItem: ModelItem){
                itemView.textView.text ="Desc : "+ modelItem.itemname
                itemView.textView2.text ="Id : "+ modelItem.itemid
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_view_items,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(arrayList[position])
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }
}