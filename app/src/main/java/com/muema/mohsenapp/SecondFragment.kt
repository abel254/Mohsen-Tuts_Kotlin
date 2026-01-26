package com.muema.mohsenapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muema.mohsenapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Initialize binding
        binding = FragmentSecondBinding.inflate(inflater, container, false)


        val dataFromActivity = arguments
        val dataFromFr1 = arguments

        // getting data from Activity
        binding.txtSecondFragment.text = "second fragment \n\n"+ "${dataFromActivity!!.get("String").toString()}"


        // getting data from fragment1
        binding.txtMsgFromFr1.text = dataFromFr1?.getString("text")

        return binding.root
    }

}