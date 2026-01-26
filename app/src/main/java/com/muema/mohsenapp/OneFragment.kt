package com.muema.mohsenapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muema.mohsenapp.databinding.FragmentOneBinding


class OneFragment : Fragment() {

    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Initialize binding
        binding = FragmentOneBinding.inflate(inflater, container, false)


        val secondFragment = SecondFragment()
        val myInterface: MyInterface = activity as MyInterface


        // Changing Textview text by button click
        binding.btnFragment1.setOnClickListener {
            binding.txtFragment1.text = "Abel.K.Developer"
        }


        // Sending text from fragment1 to fragment2
        binding.btnFr1ToFr2.setOnClickListener {

            val bundle = Bundle()

            bundle.putString("text", binding.edtFragment1.text.toString())

            secondFragment.arguments = bundle

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                    .commit()
            }
        }



        // Sending data from fragment1 to Activity using interface
        binding.btnFrag1toActivity.setOnClickListener {

            val msg = binding.edtFrag1ToActivity.text.toString()

            myInterface.transferedMessage(msg)


        }



        return binding.root
    }

}