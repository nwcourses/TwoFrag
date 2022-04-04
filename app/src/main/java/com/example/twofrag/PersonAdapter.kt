package com.example.twofrag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(val personList: List<String>, val callback: (Int)->Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPerson = itemView.findViewById<TextView>(R.id.person)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.listentry, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, index: Int) {
        val h = holder as PersonViewHolder
        h.tvPerson.setText(personList[index])
        h.itemView.setOnClickListener {
            callback(index)
        }
    }

    override fun getItemCount() : Int {
        return personList.size
    }

}