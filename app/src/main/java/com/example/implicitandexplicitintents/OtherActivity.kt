package com.example.implicitandexplicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class OtherActivity : AppCompatActivity() {
    //intent is found in the onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        //onCreate method
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        //instantiate ui element
        //listen to an event by registering an event listener
        //handle that event
        findViewById<Button>(R.id.phoneSettings).setOnClickListener{openInternalStorageSettings()}
        findViewById<Button>(R.id.createSMS).setOnClickListener{composeSMS()}
        findViewById<Button>(R.id.webBrowser).setOnClickListener{getUrlFromIntent()}
        findViewById<Button>(R.id.openFacebook).setOnClickListener{gotoFacebook()}
        findViewById<Button>(R.id.openTwitter).setOnClickListener{gotoTwitter()}
    }
    private fun openInternalStorageSettings() {
        val intent = Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun composeSMS() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
    private fun getUrlFromIntent() {
        val url = "http://www.google.com"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun gotoFacebook() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.facebook")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText( applicationContext, "ERROR! Facebook is not installed in this device.", Toast.LENGTH_LONG).show()
        }
    }
    private fun gotoTwitter() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        intent.setPackage("com.android.twitter")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        }else {
            Toast.makeText( applicationContext, "ERROR! Twitter is not installed in this device", Toast.LENGTH_LONG).show()
        }
    }
}