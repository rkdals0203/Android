package com.tutorial.c53

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val alertDialog = findViewById<Button>(R.id.alertDialogButton)
        val listDialogButton = findViewById<Button>(R.id.listDialogButton)
        val dateDialogButton = findViewById<Button>(R.id.dateDialogButton)
        val timeDialogButton = findViewById<Button>(R.id.timeDialogButton)

        alertDialog.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("test dialog")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("Ok", null)
                setNegativeButton("Cancel", null)
                show()
            }
        }
        listDialogButton.setOnClickListener {
            Toast.makeText(this, "aa", Toast.LENGTH_SHORT)
            val items = arrayOf<String>("사과", "복숭아", "수박")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setItems(items, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(
                            this@MainActivity,
                            "선택한 항목: ${items[p1]}",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                })
                setPositiveButton("Ok", null)
                show()
            }
        }

        dateDialogButton.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Toast.makeText(this@MainActivity, "$p1, ${p2 + 1}, $p3", Toast.LENGTH_SHORT)
                        .show()
                }
            }, 2022, 8, 21).show()
        }

        timeDialogButton.setOnClickListener{
            TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Toast.makeText(this@MainActivity, "$p1, ${p2 + 1}", Toast.LENGTH_SHORT).show()
                }
            } , 15, 0 , true).show()
        }
    }
}