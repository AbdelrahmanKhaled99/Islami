package com.example.islami.fragments.fragments.sura_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivitySuraDetailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var suraName: String
    lateinit var fileName: String
    lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fileName = intent.getStringExtra(Constants.FILE_NAME)!!
        suraName = intent.getStringExtra(Constants.SURA_NAME)!!

       // Log.e("SuraDetailsActivity/onCreate", "suraName = ${suraName} " + "+ file = ${fileName})")
        binding.suraContentTV.text = readFileContent()
        binding.suraNameTV.text = suraName
    }

    private fun readFileContent(): String {
        var fileContent = ""

        try {
            val inputStream = assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))

            val fileLines: List<String> = reader.readLines()
            fileContent = fileLines.joinToString(separator = "") { line ->
                val index = fileLines.indexOf(line) + 1
                return@joinToString "$line{$index}"
            }
            Log.e("SuraDetailsActivity/readFileContent", "fileContent = $fileContent")

            inputStream.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileContent
    }

}