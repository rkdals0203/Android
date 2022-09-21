package com.tutorial.c11

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var visibleButton: Button
    lateinit var invisibleButton: Button
    lateinit var logoImageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        visibleButton = findViewById(R.id.visibleButton)
        invisibleButton = findViewById(R.id.invisibleButton)
        logoImageView = findViewById(R.id.logoImangeView)

        visibleButton.setOnClickListener{
            logoImageView.visibility = View.VISIBLE
        }
        invisibleButton.setOnClickListener{
            logoImageView.visibility = View.INVISIBLE
        }
    }
}