package com.example.recycleex

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0
    private val adapter: Adapter = Adapter(this)
    private val items: MutableList<User> = mutableListOf()

    override fun onBackPressed() {

        val dialog = AlertDialog.Builder(this)
        dialog.setMessage(" Do you want exit?")
        dialog.setCancelable(false)
        dialog.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            finish()
        }
        dialog.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }
        dialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv1.adapter = adapter
        rv1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false)
        fillData(0, 1)

    }
        private fun fillData(size: Int, count: Int){
                for (i in size until count+size){
                    val item : User = User()
                    item.name = "User"
                    item.surname = "User's ID : ${i+1}"
                    items.add(item)
                }
            adapter.setData(items)
        }

    fun itemClicker(size: Int, position: Int){
        fillData(size, position+1)
        counter = position+1
        Toast.makeText(this, "added: ${position+1} \n count : ${size+position+1}  ", Toast.LENGTH_SHORT).show()
        }
    fun removeAt(position: Int, size: Int)  {

        items.removeAt(position)
        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position,size)


    }
        fun dialogAdd(size: Int){
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Do you want add one more user?")
            dialog.setMessage("Add one?")
            dialog.setCancelable(false)
            dialog.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                fillData(size, 1)
            }
            dialog.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

            }
            dialog.show()
        }

    fun dialogDelete(position: Int, size: Int){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Do you want delete this user?")
        dialog.setMessage("Remove it?")
        dialog.setCancelable(false)
        dialog.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
           removeAt(position , size)

        }
        dialog.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
        }
        dialog.show()
    }

    fun menuClicker(view: View, size: Int, position: Int){
        val optionMenu = PopupMenu(this, view)
        val menuInflater = optionMenu.menuInflater
        menuInflater.inflate(R.menu.menu_option, optionMenu.menu)
        optionMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.itemAdd -> {
                    dialogAdd(size)
                }
                R.id.itemDelete -> {
                   dialogDelete(position, size)
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionMenu.show()
    }
}
