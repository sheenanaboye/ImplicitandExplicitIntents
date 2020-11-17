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

        //instantiate ui element
        //listen to an event by registering an event listener
        //handle that event
        findViewById<Button>(R.id.loginBtn).setOnClickListener { OtherActivity() }
    }
    private fun OtherActivity() {
        //explicit
        val intent = Intent(this, OtherActivity::class.java)
        startActivity(intent)
    }
}