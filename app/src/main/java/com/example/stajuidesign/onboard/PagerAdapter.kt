package com.example.stajuidesign.onboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
const val ITEM_COUNT = 2
class PagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerContentFragment()
        Log.d("adapter_position", "$position")
        when(position) {
            0 -> fragment.arguments = Bundle().apply {
                putInt("position",position)
            }
            1 -> fragment.arguments = Bundle().apply {
                putInt("position",position)
            }
        }
        return fragment
    }
}