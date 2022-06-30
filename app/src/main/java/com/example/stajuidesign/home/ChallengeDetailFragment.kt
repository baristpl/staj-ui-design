package com.example.stajuidesign.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stajuidesign.R
import com.example.stajuidesign.databinding.FragmentChallengeDetailBinding

class ChallengeDetailFragment : Fragment() {
    private var _binding: FragmentChallengeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChallengeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favButton.setOnClickListener {
            val sharedPref =
                activity?.getPreferences(Context.MODE_PRIVATE) ?: return@setOnClickListener

            val favCount = sharedPref.getInt(getString(R.string.fav_counter), 0)

            with(sharedPref.edit()) {
                putInt(getString(R.string.fav_counter), favCount + 1)
                apply()
                Log.d("fav_count", "favorite count = $favCount")
            }
        }
    }
}