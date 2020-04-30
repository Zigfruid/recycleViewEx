package com.example.recycleex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val activity: MainActivity): RecyclerView.Adapter<ViewHolder>() {

    var item : ArrayList<User> = arrayListOf()

    fun setData(data: List<User>){
        item = data as ArrayList<User>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return  ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(item[position],itemCount, position, activity)
    }


}