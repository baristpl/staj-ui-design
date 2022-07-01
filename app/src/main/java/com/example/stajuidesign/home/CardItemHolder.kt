package com.example.stajuidesign.home

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.stajuidesign.R

class CardItemHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val image: ImageView
    val header: TextView
    val description: TextView
    val info: TextView
    val cardView: CardView

    init {
        image = view.findViewById(R.id.item_image)
        header = view.findViewById(R.id.item_header)
        description = view.findViewById(R.id.item_description)
        info = view.findViewById(R.id.item_info)
        cardView = view.findViewById(R.id.cardView)
    }

}
