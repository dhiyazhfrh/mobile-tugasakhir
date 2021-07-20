package com.example.mobile_tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun login(view: View){
        val pass = findViewById<EditText>(R.id.login_pass)
        var passcode = pass.text.toString()
            if (passcode == "group2") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "You insert a wrong pin !", Toast.LENGTH_SHORT).show()
            }

    }
}