package com.tutorial.c68

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.resultView)
        val button = findViewById<Button>(R.id.button)

        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply{
            var isCharging = "Not plugged"
            when(getIntExtra(BatteryManager.EXTRA_STATUS, -1)){
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    when(getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)){
                        BatteryManager.BATTERY_PLUGGED_USB->{
                            isCharging="USB plugged"
                        }
                        BatteryManager.BATTERY_PLUGGED_AC ->{
                            isCharging = "AC plugged"
                        }
                    }
                }
            }
            val level = getIntExtra(BatteryManager.EXTRA_LEVEL,-1)
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE,-1)
            val batteryPct = level / scale.toFloat()*100
            resultView.text = "$isCharging, $batteryPct %"

        }
        button.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            sendBroadcast(intent)
        }
    }
}