package com.example.recycleex

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        private var count: Int = 0

    private val adapter: Adapter = Adapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv1.adapter = adapter
        rv1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false)
        count+=1
        fillData()

    }
        private fun fillData(){
                val items: MutableList<User> = mutableListOf()
                for (i in 0 until 1){
                    val item : User = User()
                    item.name = "User"
                    item.surname = "User's ID : ${i+1}"
                    items.add(item)
                }
            adapter.setData(items)
        }
    fun itemClicker(user: User){
            val a = user.num
            count+=a

            val items: MutableList<User> = mutableListOf()
            for (i in 0 until count){
                val item: User = User()
                item.name = "User"
                item.num +=i
                item.surname = "User's ID : ${i+1}"
                items.add(item)
            }
        adapter.setData(items)
        Toast.makeText(this, "Was added : ${user.num} \n Count of users : $count", Toast.LENGTH_SHORT).show()
    }
}
