package com.example.islami.fragments.fragments.ahadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.model.HadethModel

class AhadethAdapter (private var ahadeth: List<HadethModel>) : RecyclerView.Adapter<AhadethAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hadethNameTV: TextView = itemView.findViewById(R.id.itemm_sura_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ahadeth.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = ahadeth[position].title
        holder.hadethNameTV.text = title
        if (onHadethClick != null) {
            holder.itemView.setOnClickListener {
                onHadethClick!!.onItemClick(ahadeth[position],position)
            }
        }

    }

    var onHadethClick: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(hadeth: HadethModel, index: Int) {

        }
    }
}
