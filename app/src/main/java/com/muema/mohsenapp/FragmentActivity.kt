package com.muema.mohsenapp

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muema.mohsenapp.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity(), MyInterface {

    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val firstFragment = OneFragment()
        val secondFragment = SecondFragment()



        binding.btnFirstFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()

                binding.textView2.visibility = INVISIBLE
            }
        }

        binding.btnSecondFragment.setOnClickListener {

            val bundle = Bundle()

            bundle.putString("String", binding.edtFragmentActivity.text.toString())

            secondFragment.arguments = bundle

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()

                binding.textView2.visibility = INVISIBLE
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun transferedMessage(msg: String) {
        binding.textView4.text = msg
    }
}