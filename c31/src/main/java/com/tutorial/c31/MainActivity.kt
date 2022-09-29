package com.tutorial.c31

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.main_list) //xml파일에서 작성한 listview 객체로서 얻기
        val datas = resources.getStringArray(R.array.locations)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            datas
        )
    listView.adapter=adapter

    }
}