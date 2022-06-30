package com.example.stajuidesign.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.stajuidesign.R

class CardRecyclerAdapter(private val data: ArrayList<CardItemModel>) :
    RecyclerView.Adapter<CardItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemHolder {

        val layout = when(data[0].imageSource) {
            R.drawable.challenge_image -> R.layout.challenge_item
            R.drawable.challenge_image_wide -> R.layout.challenge_item_wide
            else -> R.layout.program_item
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return CardItemHolder(view)
    }

    override fun onBindViewHolder(holder: CardItemHolder, position: Int) {
        holder.image.setImageResource(data[position].imageSource)
        holder.header.setText(data[position].headerSource)
        holder.description.setText(data[position].descriptionSource)
        holder.info.setText(data[position].infoSource)

        if (data[position].destination != null){
            holder.image.setOnClickListener {
                holder.image.findNavController().navigate(data[position].destination!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}