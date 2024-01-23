package com.example.islami.fragments.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Constants
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.fragments.fragments.quran.adapters.SuraNamesAdapter
import com.example.islami.fragments.fragments.sura_details.SuraDetailsActivity


class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var suraNamesAdapter: SuraNamesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        suraNamesAdapter = SuraNamesAdapter(Constants.SURAS_NAME_LIST)
        suraNamesAdapter.onSuraClick = object : SuraNamesAdapter.OnItemClickListener {
            override fun onItemClick(suraName: String, index: Int) {
                val intent = Intent(activity, SuraDetailsActivity::class.java)
                intent.putExtra(Constants.FILE_NAME, "${index + 1}.txt")
                intent.putExtra(Constants.SURA_NAME, suraName)
                startActivity(intent)
            }
        }
        binding.suraNameRecyclerView.adapter = suraNamesAdapter
    }

}