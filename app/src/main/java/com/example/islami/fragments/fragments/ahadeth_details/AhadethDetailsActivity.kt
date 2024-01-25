package com.example.islami.fragments.fragments.ahadeth_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivityAhadethDetailsBinding
import com.example.islami.model.HadethModel

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityAhadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(Constants.HADETH_KEY ,HadethModel::class.java)
        } else {
            intent.getSerializableExtra(Constants.HADETH_KEY)as HadethModel
        }
        binding.hadethNameTV.text = hadeth!!.title
        binding.hadethContentTV.text = hadeth!!.content
    }
}