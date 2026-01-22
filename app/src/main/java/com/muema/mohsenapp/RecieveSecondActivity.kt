package com.muema.mohsenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecieveSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recieve_second)


        val edit_data = findViewById<EditText>(R.id.edit_txt_recieve)
        val btn_send = findViewById<TextView>(R.id.btn_send_second)

        btn_send.setOnClickListener {

            val intent = Intent(this, RecieveMainActivity::class.java)
            intent.putExtra("data", edit_data.text.toString())

            setResult(Activity.RESULT_OK, intent)

            finish()

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}