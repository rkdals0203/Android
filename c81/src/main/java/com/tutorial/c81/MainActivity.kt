package com.tutorial.c81

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var resultView: TextView
    lateinit var manager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultView)
        manager = getSystemService(LOCATION_SERVICE) as LocationManager

        val launcher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){isGranted ->
            if(isGranted){
                getLocation()
            }else{
                Toast.makeText(this,"denied..",Toast.LENGTH_SHORT).show()

            }
        }

        val status = ContextCompat.checkSelfPermission(this,
            "android.permission.ACCESS_FINE_LOCATION")
        if(status== PackageManager.PERMISSION_GRANTED){
            getLocation()
        }else{
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

    }

    fun getLocation(){
        val location = manager.getLastKnownLocation((LocationManager.GPS_PROVIDER))
        location?.let{
            val latitude = location.latitude
            val longitude = location.longitude
            val accuracy = location.accuracy
            val time = location.time

            resultView.text = "$latitude, $location, $accuracy, $time"
        }
    }
}