package com.example.mobile_tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login()



    }

    private fun login(){
        val pass = findViewById<EditText>(R.id.login_pass)
        val btn = findViewById<Button>(R.id.login_button)
        val pinNumber = pass.text.toString()

        btn.setOnClickListener {
            if(pinNumber == "1234"){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                Toast.makeText(this, "You insert a wrong pin !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun reset(){
        val reset = findViewById<TextView>(R.id.reset)
        reset.setOnClickListener{
            startActivity(Intent(this, ResetActivity::class.java))
        }
    }
}