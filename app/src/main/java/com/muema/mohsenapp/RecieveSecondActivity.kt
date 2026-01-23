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
import com.muema.mohsenapp.databinding.ActivityRecieveSecondBinding

class RecieveSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecieveSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecieveSecondBinding.inflate(layoutInflater)

        setContentView(binding.root)


        // val edit_data = findViewById<EditText>(R.id.edit_txt_recieve)
        // val btn_send = findViewById<TextView>(R.id.btn_send_second)

        binding.btnSendSecond.setOnClickListener {

            val intent = Intent(this, RecieveMainActivity::class.java)
            intent.putExtra("data", binding.editTxtRecieve.text.toString())

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