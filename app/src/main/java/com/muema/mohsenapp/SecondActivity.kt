package com.muema.mohsenapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)


        val btnSend = findViewById<Button>(R.id.button)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val chBox = findViewById<CheckBox>(R.id.checkBox)

        var chBoxState = false

        chBox.setOnCheckedChangeListener { buttonView, isChecked ->
             if (isChecked) chBoxState = true
            if (!isChecked) chBoxState = false
        }

        btnSend.setOnClickListener {
            var name = edtName.text.toString()
            var age = edtAge.text.toString().toInt()

            val intent = Intent(this, IntentActivity::class.java)

            intent.putExtra("Name", name)
            intent.putExtra("Age", age)
            intent.putExtra("State", chBoxState)

            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}