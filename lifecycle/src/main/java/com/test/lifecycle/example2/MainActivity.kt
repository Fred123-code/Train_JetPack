package com.test.lifecycle.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.lifecycle.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}