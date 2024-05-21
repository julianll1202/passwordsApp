package com.example.passwordapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var btnLogin: Button
    lateinit var mAuth: FirebaseAuth
    lateinit var textView: TextView
    lateinit var btnGuest: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.loginBtn)
        mAuth = FirebaseAuth.getInstance()
        btnGuest = findViewById(R.id.btnGuest)
        textView = findViewById(R.id.registerNow)
        textView.setOnClickListener{ onClick(it)}
        btnGuest.setOnClickListener{ onClickGuest(it)}
        btnLogin.setOnClickListener{
            handleClick(it)
        }
    }

    fun onClick(view: View) {
        startActivity(Intent(applicationContext, Register::class.java))
        finish()
    }

    fun onClickGuest(view: View) {
        startActivity(Intent(applicationContext, GuestView::class.java))
        finish()
    }

    fun handleClick(view: View) {
        var email: String
        var password: String
        email = editTextEmail.text.toString()
        password = editTextPassword.text.toString()

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Login succesful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
}