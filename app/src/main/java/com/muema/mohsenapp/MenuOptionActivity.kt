package com.muema.mohsenapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_option)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.setting -> Toast.makeText(this, "setting selected", Toast.LENGTH_SHORT).show()
            R.id.alert -> Toast.makeText(this, "alert selected", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "delete selected", Toast.LENGTH_SHORT).show()
            R.id.add -> Toast.makeText(this, "add selected", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}