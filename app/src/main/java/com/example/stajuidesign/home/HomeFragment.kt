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

        val challengeRecyclers = arrayListOf<RecyclerView>()
        challengeRecyclers.apply {
            add(binding.challengeRecycler1)
            add(binding.challengeRecycler2)
            add(binding.challengeRecycler3)
        }

        val programContentList = arrayListOf<CardItemModel>()

        for (i in 1..2) {
            programContentList.add(
                CardItemModel(
                    R.drawable.program_image_one,
                    R.string.program_header,
                    R.string.program_description,
                    R.string.program_info
                ).apply {
                    destination = R.id.challenge_detail_des
                }
            )

            programContentList.add(
                CardItemModel(
                    R.drawable.program_image_two,
                    R.string.program_header2,
                    R.string.program_description,
                    R.string.program_info
                )
            )
        }

        val challengeContentList = arrayListOf<CardItemModel>()

        for (i in 1..3) {
            challengeContentList.add(
                CardItemModel(
                    R.drawable.challenge_image,
                    R.string.challenge_header,
                    R.string.challenge_description,
                    R.string.challenge_info
                )
            )
        }

        val programAdapter = CardRecyclerAdapter(programContentList)
        val challengeAdapter = CardRecyclerAdapter(challengeContentList)

        challengeRecyclers.forEach {
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