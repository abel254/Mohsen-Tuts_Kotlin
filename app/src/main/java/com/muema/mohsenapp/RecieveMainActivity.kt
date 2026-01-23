package com.muema.mohsenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muema.mohsenapp.databinding.ActivityRecieveMainBinding

class RecieveMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecieveMainBinding

    var resultText = ""

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->

        if (result?.resultCode == Activity.RESULT_OK){
            resultText = result.data?.getStringExtra("data").toString()

            val text_results = findViewById<TextView>(R.id.txt_view_recieve)
            text_results.text = resultText
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecieveMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //val btn_next = findViewById<TextView>(R.id.btn_next)

        binding.btnNext.setOnClickListener {

            val intent = Intent(this, RecieveSecondActivity::class.java)

            resultContract.launch(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}