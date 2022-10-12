package com.tutorial.c51

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val status = ContextCompat.checkSelfPermission(
            this,
            "android.permission.ACCESS_FINE_LOCATION"
        )

        if(status==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"granted . . .", Toast.LENGTH_SHORT).show()
        }
        else{
            //test1
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>("android.permission.ACCESS_FINE_LOCATION"),
                100
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"granted . . .", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"denied. . .", Toast.LENGTH_SHORT).show()
        }
    }
}