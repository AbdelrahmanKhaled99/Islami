package com.example.islami.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islami.databinding.ActivitySplashBinding
import com.example.islami.fragments.fragments.HomeActivity

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startHomeScreen()

    }

    private fun startHomeScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent : Intent = Intent(this , HomeActivity :: class.java)
            startActivity(intent)
            finish()
        } , 500)


    }
}