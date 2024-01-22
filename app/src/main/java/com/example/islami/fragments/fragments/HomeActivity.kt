package com.example.islami.fragments.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.fragments.fragments.ahadeth.AhadethFragment
import com.example.islami.fragments.fragments.quran.QuranFragment
import com.example.islami.fragments.fragments.radio.RadioFragment
import com.example.islami.fragments.fragments.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment(QuranFragment())
        initListeners()
    }

    fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
    fun initListeners(){
        binding.bottomNav.setOnItemSelectedListener {
            if (it.itemId == R.id.ic_quran) {
                startFragment(QuranFragment())
            } else if (it.itemId == R.id.ic_ahadeth) {
                startFragment(AhadethFragment())
            } else if (it.itemId == R.id.ic_sebha) {
                startFragment(SebhaFragment())
            } else if (it.itemId == R.id.ic_radio) {
                startFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }

    }
}