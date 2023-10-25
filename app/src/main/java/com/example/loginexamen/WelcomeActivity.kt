package com.example.loginexamen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.loginexamen.model.Persona

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val user = intent.getSerializableExtra("USER") as? Persona
        if (user != null) {
            val welcomeMessage = "Welcome, ${user.name} ${user.lastName}!"
            val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
            welcomeTextView.text = welcomeMessage
        }

        val backToLoginButton = findViewById<Button>(R.id.backToLoginButton)
        backToLoginButton.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Finish the WelcomeActivity after navigating back to the MainActivity
        }
    }
}
