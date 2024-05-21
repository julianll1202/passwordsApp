package com.example.passwordapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSignOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSignOut = findViewById(R.id.btnSignOut)
        btnSignOut.setOnClickListener{ onClick(it)}
    }

    fun onClick(view: View) {
        startActivity(Intent(applicationContext, Login::class.java))
        finish()
    }
}