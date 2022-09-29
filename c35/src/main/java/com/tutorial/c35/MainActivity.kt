package com.tutorial.c35

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.auto)
        val datas = resources.getStringArray(R.array.language)

        val adapter : ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_dropdown_item_1line, datas
        )
        spinner.adapter = adapter




        val autoDatas = arrayOf<String>("apply","apple","below")
        val autoAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            autoDatas
        )
        autoCompleteTextView.setAdapter((autoAdapter))
    }
}