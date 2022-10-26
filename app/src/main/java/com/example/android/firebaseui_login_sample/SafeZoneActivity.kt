package com.example.android.firebaseui_login_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SafeZoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safe_zone)

        val goBackButton = findViewById<TextView>(R.id.go_back_button)
        goBackButton.setOnClickListener {
            val Intent = Intent( this,MainActivity::class.java)
            startActivity(Intent)
        }
    }
}
