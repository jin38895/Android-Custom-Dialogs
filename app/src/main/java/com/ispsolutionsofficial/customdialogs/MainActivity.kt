package com.ispsolutionsofficial.customdialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSnackBars:Button = findViewById(R.id.btnSnackBars)
        val btnAlertDialog:Button = findViewById(R.id.btnAlertDialog)
        val btnCustomDialog:Button = findViewById(R.id.btnCustomDialog)
        val btnCustomProgressBar:Button = findViewById(R.id.btnCustomProgressBar)

        btnSnackBars.setOnClickListener {
            Snackbar.make(it, "This is a Snack Bar!!!", Snackbar.LENGTH_LONG).show()
        }

        btnAlertDialog.setOnClickListener {
            showAlertDialog()
        }

        btnCustomDialog.setOnClickListener {
            showCustomDialog()
        }

        btnCustomProgressBar.setOnClickListener {
            showCustomProgressBar()
        }
    }

    private fun showCustomProgressBar() {
        val progressBarDialog: Dialog = Dialog(this)

        progressBarDialog.setContentView(R.layout.custom_progress_bar_dialog)
        progressBarDialog.show()
    }

    private fun showCustomDialog() {
        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setView(R.layout.custom_dialog_layout)
        builder.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, which ->
            Toast.makeText(applicationContext,"Yes for custom dialog!!", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        })
        builder.setNeutralButton("No", DialogInterface.OnClickListener{ dialogInterface, which ->
            Toast.makeText(applicationContext, "No for custom dialog!!", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        })
        builder.show()
    }

    private fun showAlertDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setIcon(R.drawable.ic_launcher_foreground)
        builder.setMessage("This is an Alert Dialog Box showing Alert Message!!")

        // Performing Positive button action
        builder.setPositiveButton("Yes") { dialogInterface, which ->
            Toast.makeText(applicationContext, "Yes for Alert!!!", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        // Performing Negative button action
        builder.setNegativeButton("No") {dialogInterface, which ->
            Toast.makeText(applicationContext,"No for Alert!!!", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        // Performing Cancel button action
        builder.setNeutralButton("Cancel") { dialogInterface, which ->
            Toast.makeText(applicationContext,"Cancel for Alert!!!", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog:AlertDialog = builder.create()
        alertDialog.setCancelable(false) // This will not allow user to cancel the alert by clicking outside the alert dialog
        alertDialog.show()
    }
}