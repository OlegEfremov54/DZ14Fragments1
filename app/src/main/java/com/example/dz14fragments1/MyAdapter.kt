package com.example.dz14fragments1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (val textMess: MutableList<TextMes>) :
    RecyclerView.Adapter<MyAdapter.TextViewHolder>() {

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countTV: TextView = itemView.findViewById(R.id.countTV)
        val textTV: TextView = itemView.findViewById(R.id.textTV)
        var dateTV: TextView = itemView.findViewById(R.id.dateTV)
        val checkBoxStartCB:CheckBox = itemView.findViewById(R.id.checkBoxStartCB)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return TextViewHolder(itemView)
    }

    override fun getItemCount() = textMess.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val note = textMess[position]
        holder.countTV.text = note.count.toString()
        holder.textTV.text = note.text
        holder.dateTV.text = note.date
        holder.checkBoxStartCB.isChecked = note.checkBoxStart
    }
}