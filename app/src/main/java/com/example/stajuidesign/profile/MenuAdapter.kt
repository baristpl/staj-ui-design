package com.example.stajuidesign.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.stajuidesign.R

class MenuAdapter(private val menuList: ArrayList<MenuItemModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return menuList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var menuItem = convertView
        if (convertView == null) {
            menuItem =
                LayoutInflater.from(parent?.context).inflate(R.layout.menu_item, parent, false);
        }

        menuItem?.apply {
            findViewById<ImageView>(R.id.menu_icon).setImageResource(menuList[position].iconSource)
            findViewById<TextView>(R.id.menu_text).setText(menuList[position].textSource)
        }
        return menuItem!!
    }
}