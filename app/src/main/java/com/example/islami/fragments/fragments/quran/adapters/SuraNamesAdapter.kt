package com.example.islami.fragments.fragments.quran.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.R

class SuraNamesAdapter(var suraName: List<String>) : Adapter<SuraNamesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val suraNameTV = itemView.findViewById<TextView>(R.id.itemm_sura_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suraName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = suraName[position]
        holder.suraNameTV.text = suraName
        if (onSuraClick != null) {
            holder.itemView.setOnClickListener {
                onSuraClick!!.onItemClick(suraName,position)
            }
        }

    }

    var onSuraClick: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(suraName: String, index: Int) {

        }
    }
}