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

class Register : AppCompatActivity() {
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var copyPassword: EditText
    lateinit var btnReg: Button
    lateinit var mAuth: FirebaseAuth
    lateinit var textView: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.password)
        copyPassword = findViewById(R.id.confirmPassword)
        btnReg = findViewById(R.id.registerBtn)
        mAuth = FirebaseAuth.getInstance()
        textView = findViewById(R.id.loginNow)
        textView.setOnClickListener{
            onClick(it)
        }
        btnReg.setOnClickListener{handleClick(it)
        }
    }
    fun onClick(view: View) {
        startActivity(Intent(applicationContext, Login::class.java))
        finish()
    }

    fun handleClick(view: View) {
        var email: String
        var password: String
        var copyPass: String
        email = editTextEmail.text.toString()
        password = editTextPassword.text.toString()
        copyPass = copyPassword.text.toString()

        if (email.isEmpty() or password.isEmpty() or copyPass.isEmpty()) {
            Toast.makeText(applicationContext, "There can be no empty fields", Toast.LENGTH_SHORT).show()
            return
        }
        if (!copyPass.equals(password)) {
            Toast.makeText(applicationContext, "Passwords must be the same", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        baseContext,
                        "Account created.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    startActivity(Intent(applicationContext, Login::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Account creation failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

}