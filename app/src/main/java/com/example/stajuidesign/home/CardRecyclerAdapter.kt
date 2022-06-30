package com.example.stajuidesign.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stajuidesign.R

class CardRecyclerAdapter(private val data: ArrayList<CardViewModel>) :
    RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        val layout = if (R.drawable.challenge_image == data[0].imageSource)
            R.layout.challenge_item else R.layout.program_item

        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.image.setImageResource(data[position].imageSource)
        holder.header.setText(data[position].headerSource)
        holder.description.setText(data[position].descriptionSource)
        holder.info.setText(data[position].infoSource)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}