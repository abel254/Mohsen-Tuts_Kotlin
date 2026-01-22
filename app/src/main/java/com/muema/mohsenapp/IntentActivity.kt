package com.muema.mohsenapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent)


        val txtRes = findViewById<TextView>(R.id.textView)

        val intent = getIntent()

        val name = intent.getStringExtra("Name")!!
        val age = intent.getIntExtra("Age", 0)
        val chBoxState = intent.getBooleanExtra("State", false)

        txtRes.text = "collected data \n\n name: "+name+"\n age: "+age+"\nstate: "+chBoxState


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}