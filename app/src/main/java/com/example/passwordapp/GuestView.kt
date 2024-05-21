package com.example.passwordapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GuestView : AppCompatActivity() {
    lateinit var btnToLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_view)
        btnToLogin = findViewById(R.id.goToLogin)
        btnToLogin.setOnClickListener{ onClick(it) }
    }
    fun onClick(view: View) {
        startActivity(Intent(applicationContext, Login::class.java))
        finish()
    }
}