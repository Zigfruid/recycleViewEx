package com.example.recycleex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val activity: MainActivity): RecyclerView.Adapter<ViewHolder>() {

    var item : MutableList<User> = mutableListOf()

    fun setData(data: MutableList<User>){
        item = data
        notifyDataSetChanged()
    }
    fun addItem(position: Int ){
        item.add(position, User("User", "User's ID ${item.size+1}"))
       notifyItemInserted(position)
        notifyItemRangeChanged(position,item.size)

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