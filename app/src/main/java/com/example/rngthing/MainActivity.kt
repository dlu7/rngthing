package com.example.rngthing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var et_min: EditText? = null
    private var et_max:EditText? = null
    private var b_generator: Button? = null
    private var tv_output: TextView? = null

    var r: Random? = null
    var min: Int = 0
    var max:Int = 0
    var output:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        r = Random()

        et_min = findViewById(R.id.et_min)
        et_max = findViewById(R.id.et_max)
        b_generator = findViewById(R.id.b_generator)
        tv_output = findViewById(R.id.tv_output)

        b_generator!!.setOnClickListener {
            val tempMin:String = et_min!!.text.toString()
            val tempMax:String = et_max!!.text.toString()
            if (tempMin != "" && tempMax != "") {
                min = Integer.parseInt(tempMin)
                max = Integer.parseInt(tempMax)
                if (max > min) {
                    output = r!!.nextInt((max - min) + 1) + min
                    tv_output!!.text = "" + output
                }
            }
        }
    }
}
