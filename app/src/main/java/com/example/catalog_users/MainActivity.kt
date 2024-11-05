package com.example.catalog_users

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var button: Button
    private lateinit var listTv: ListView
    val list: MutableList<Users> = mutableListOf()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> finish()

        }

        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


          name = findViewById(R.id.name)
          age = findViewById(R.id.age)
          button = findViewById(R.id.button)
          listTv = findViewById(R.id.listView)
          toolbar = findViewById(R.id.toolbarMain)

          setSupportActionBar(toolbar)
          toolbar.setTitleTextColor(getColor(R.color.blue))
           title = ("     Каталог пользователей")

        val adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,list)
        listTv.adapter = adapter

                 button.setOnClickListener {
                  if( name.text.isEmpty() or age.text.isEmpty()) { return@setOnClickListener }

                     list += listOf(Users(name.text.toString(),age.text.toString()))
                    // list.add(Users(name.text.toString(),age.text.toString()))
                     adapter.notifyDataSetChanged()
                     name.text.clear();age.text.clear() }
                listTv.onItemClickListener = AdapterView.OnItemClickListener{s,v,position,id->

                    val note = adapter.getItem(position)
                    adapter.remove(note)
                }
    }

}

   class Users (val name: String,val age: String){

       override fun toString() = "Имя: ${name}            Возраст: ${age}" }

