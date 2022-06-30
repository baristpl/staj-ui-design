package com.example.stajuidesign.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stajuidesign.R
import com.example.stajuidesign.databinding.FragmentHomeBinding
import com.example.stajuidesign.databinding.FragmentViewPagerBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val programRecycler = binding.programsRecycler

        val challenges = arrayListOf<RecyclerView>()
        challenges.apply {
            add(binding.challengeRecycler1)
            add(binding.challengeRecycler2)
            add(binding.challengeRecycler3)
        }

        val programContentList = arrayListOf<CardViewModel>()

        for (i in 1..2) {
            programContentList.add(
                CardViewModel(
                    R.drawable.program_one_image,
                    R.string.program_header,
                    R.string.program_description,
                    R.string.program_info
                )
            )

            programContentList.add(
                CardViewModel(
                    R.drawable.program_two_image,
                    R.string.program_header,
                    R.string.program_description,
                    R.string.program_info
                )
            )
        }

        val challengeContentList = arrayListOf<CardViewModel>()

        for (i in 1..3) {
            challengeContentList.add(
                CardViewModel(
                    R.drawable.challenge_image,
                    R.string.challenge_header,
                    R.string.challenge_description,
                    R.string.challenge_info
                )
            )
        }

        val programAdapter = CardRecyclerAdapter(programContentList)
        val challengeAdapter = CardRecyclerAdapter(challengeContentList)

        challenges.forEach {
            it.layoutManager = LinearLayoutManager(
                view.context,
                RecyclerView.HORIZONTAL,
                false
            )
            it.adapter = challengeAdapter
        }

        programRecycler.apply {
            layoutManager = LinearLayoutManager(
                view.context,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = programAdapter
        }
    }
}