package com.tutorial.c43

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent()
            intent.action = "ACTION_DETAIL"
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }
    }
}