package com.example.stajuidesign.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.stajuidesign.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val pagerIndicator = view.findViewById<TabLayout>(R.id.pager_indicator)
        val nextButton = view.findViewById<Button>(R.id.button)

        val adapter = PagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(pagerIndicator, viewPager)
        { tab, position ->}.attach()

        nextButton.setOnClickListener {
            val position = viewPager.currentItem

            when(position){
                0 -> viewPager.setCurrentItem(viewPager.currentItem + 1)
                1 -> findNavController().navigate(R.id.login_fragment_des)
            }

        }
    }


}