package com.example.implicitandexplicitintents

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //intent is found in the onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        //onCreate method
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }