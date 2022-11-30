package com.tutorial.c82

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    lateinit var resultView: TextView
    lateinit var providerClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultView)

        val apiClient = GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks((connectionCallback))
            .addOnConnectionFailedListener(connectionFailedCallback)
            .build()
        providerClient = LocationServices.getFusedLocationProviderClient(this)

        val launcher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            if(it){
                apiClient.connect()
            }else{
                Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show()
            }
        }
        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            apiClient.connect()
        }else{
            launcher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    val connectionCallback = object : GoogleApiClient.ConnectionCallbacks{
        override fun onConnected(p0: Bundle?) {
            providerClient.lastLocation.addOnSuccessListener {
                val latitude = it?.latitude
                val longitude = it?.longitude
                resultView.text = "$latitude, $longitude"
            }
        }

        override fun onConnectionSuspended(p0: Int) { //이 함수가 콜된다는 것은 이용가능한 프로바이더가 이용불가능한 상태가 되었을때, 구현은 x
            TODO("Not yet implemented")
        }
    }

    val connectionFailedCallback = object: GoogleApiClient.OnConnectionFailedListener{ //폰의 모든 프로바이더가 이용이 안될 때, 구현은 x
        override fun onConnectionFailed(p0: ConnectionResult) {
            TODO("Not yet implemented")
        }
    }
}






















