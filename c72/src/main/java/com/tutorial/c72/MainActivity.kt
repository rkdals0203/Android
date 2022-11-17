package com.tutorial.c72

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var binder: MyService.MyBinder

    val connection: ServiceConnection = object : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            binder = p1 as MyService.MyBinder
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<ImageView>(R.id.startButton)
        val stopButton = findViewById<ImageView>(R.id.stopButton)

        startButton.setOnClickListener{
            binder.startMusic()
            startButton.setEnabled(false)
            stopButton.setEnabled(true)
        }

        stopButton.setOnClickListener{
            binder.stopMusic()
            startButton.setEnabled(true)
            stopButton.setEnabled(false)
        }

        val intent = Intent(this, MyService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }
}