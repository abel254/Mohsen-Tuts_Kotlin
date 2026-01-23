package com.muema.mohsenapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.muema.mohsenapp.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Alert dialog")
                .setMessage("Are you sure about this action?")
                .setNeutralButton("cancel"){ _,_ ->
                    Snackbar.make(it, "cancel", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("no"){ _,_ ->
                    Snackbar.make(it, "no", Snackbar.LENGTH_SHORT).show()
                }
                .setPositiveButton("yes"){ _,_ ->
                    Snackbar.make(it, "yes", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}