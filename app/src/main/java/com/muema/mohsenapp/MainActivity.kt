package com.muema.mohsenapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muema.mohsenapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

        /*
        val btn1 = findViewById<Button>(R.id.intentData)
        val btnIntentRecieve = findViewById<Button>(R.id.btnIntentRecieve)

         */

        // Intent Data Transfer

        binding.intentData.setOnClickListener {
            val intent1 = Intent(this, SecondActivity::class.java)
            startActivity(intent1)
        }

        // Intent Recieve Data from Second Activity

        binding.btnIntentRecieve.setOnClickListener {
            val intent = Intent(this, RecieveMainActivity::class.java)
            startActivity(intent)
        }

        // Menu Option

        binding.menuOption.setOnClickListener {
            val intent = Intent(this, MenuOptionActivity::class.java)
            startActivity(intent)
        }

        // Alert Dialog

        binding.btnAlertDialog.setOnClickListener {
            val intent = Intent(this, AlertDialogActivity::class.java)
            startActivity(intent)
        }

        // Linear Layout Sample

        binding.btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        // Fragments Sample

        binding.btnFragmentActivity.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}