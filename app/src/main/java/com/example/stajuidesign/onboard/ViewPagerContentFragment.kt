package com.example.stajuidesign.onboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.stajuidesign.R

class ViewPagerContentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_view_pager_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position")
        Log.d("content_position","$position")
        val onboardImage = view.findViewById<ImageView>(R.id.onboard_image)

        when(position){
            0 -> onboardImage.setImageResource(R.drawable.onboard_design)
            1 -> onboardImage.setImageResource(R.drawable.onboard_design)
        }
    }
}