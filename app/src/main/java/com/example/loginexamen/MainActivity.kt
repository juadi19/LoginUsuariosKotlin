package com.example.loginexamen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginexamen.model.Persona

class MainActivity : AppCompatActivity() {

    private val usersList = listOf(
        Persona("Pedro", "Picapiedra", "pedro", "pedro"),
        Persona("Tigre", "Toño", "tigre", "tigre")
        // Agrega más usuarios precreados si es necesario
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginbutton)

        loginButton.setOnClickListener {
            val enteredUsername = username.text.toString()
            val enteredPassword = password.text.toString()

            val user = usersList.find { it.username == enteredUsername && it.password == enteredPassword }

            if (user != null) {
                val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
                intent.putExtra("USER", user)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
