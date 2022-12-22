package com.tutorial.c91

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tutorial.c91.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val OneFragment = OneFragment()
        val TwoFragment = TwoFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        transaction.add(R.id.fragment_content, OneFragment)
        transaction.commit()

        binding.oneButton.setOnClickListener {
            val tran = manager.beginTransaction()
            tran.replace(R.id.fragment_content, OneFragment)
            tran.commit()
        }
        binding.twoButton.setOnClickListener {
            val tran = manager.beginTransaction()
            tran.replace(R.id.fragment_content, TwoFragment)
            tran.commit()
        }
    }
}