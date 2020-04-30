package com.example.recycleex

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
 private    val tvName: TextView = itemView.tv1
 private   val tvSurname: TextView = itemView.tv2


    fun populateModel(user: User, size: Int,  position: Int, activity: MainActivity){
            tvName.text = user.name
            tvSurname.text = user.surname
            itemView.setOnClickListener {
                activity.itemClicker(size,position)
            }
        itemView.ivMenu.setOnClickListener {
            activity.menuClicker(itemView.ivMenu, size, position)
        }
    }
}