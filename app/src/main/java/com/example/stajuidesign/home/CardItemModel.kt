package com.example.stajuidesign.home

import android.view.View

data class CardItemModel(
    val imageSource: Int,
    val headerSource: Int,
    val descriptionSource: Int,
    val infoSource: Int,
    ){
    var destination: Int? = null
}