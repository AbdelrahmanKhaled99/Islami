package com.example.islami.fragments.fragments.ahadeth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Constants
import com.example.islami.databinding.FragmentAhadethBinding
import com.example.islami.fragments.fragments.ahadeth_details.AhadethDetailsActivity
import com.example.islami.model.HadethModel
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class AhadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    var ahadeth = mutableListOf<HadethModel>()
    lateinit var ahadethAdapter: AhadethAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadeth()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        ahadethAdapter = AhadethAdapter(ahadeth)
        ahadethAdapter.onHadethClick = object : AhadethAdapter.OnItemClickListener {
            override fun onItemClick(hadeth: HadethModel, index: Int) {
                val intent = Intent (activity , AhadethDetailsActivity::class.java)
                intent.putExtra(Constants.HADETH_KEY , hadeth)
                startActivity(intent)
            }
        }
        binding.ahadethRecyclerView.adapter = ahadethAdapter
    }

    private fun readAhadeth() {
        try {
            val inputStream = requireActivity().assets.open("ahadeeth.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val hadethFileContent = reader.readText()
            val ahadethList: List<String> = hadethFileContent.split("#")
            for (hadeth: String in ahadethList) {
                val singleHadethWithoutSpaces = hadeth.trim()
                val singleHadethLines: MutableList<String> =
                    singleHadethWithoutSpaces.split("\n").toMutableList()
                val ahadethTitles = singleHadethLines[0]
                singleHadethLines.removeAt(0)
                val content = singleHadethLines.joinToString(separator = " ") {
                    return@joinToString it
                }
                ahadeth.add(HadethModel(title = ahadethTitles, content = content))

            }
            inputStream.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

