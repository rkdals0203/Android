package com.tutorial.c40

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java) //두 번째 인수가 인텐트에 의해서 실행돼야할 컴포넌트 정보!
            startActivity(intent)
        }
    }
}