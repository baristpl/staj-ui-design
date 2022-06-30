package com.example.stajuidesign.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stajuidesign.R
import com.example.stajuidesign.databinding.FragmentProfileBinding
import com.example.stajuidesign.home.CardItemModel
import com.example.stajuidesign.home.CardRecyclerAdapter

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuList = arrayListOf<MenuItemModel>()

        menuList.add(MenuItemModel(R.drawable.menu_icon_settings, R.string.menu_item1))
        menuList.add(MenuItemModel(R.drawable.menu_icon_article, R.string.menu_item2))
        menuList.add(MenuItemModel(R.drawable.menu_icon_reminder, R.string.menu_item3))
        menuList.add(MenuItemModel(R.drawable.menu_icon_app_settings, R.string.menu_item4))
        menuList.add(MenuItemModel(R.drawable.menu_icon_premium, R.string.menu_item5))

        val adapter = MenuAdapter(menuList)
        binding.profileMenu.adapter = adapter

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val favCount = sharedPref.getInt(getString(R.string.fav_counter), 0)

        val favoriteList = arrayListOf<CardItemModel>()

        for (i in 1..favCount) {
            favoriteList.add(
                CardItemModel(
                    R.drawable.challenge_image_wide,
                    R.string.challenge_header,
                    R.string.challenge_description,
                    R.string.challenge_info
                )
            )
        }
        val favoritesRecyclerAdapter = CardRecyclerAdapter(favoriteList)

        binding.favorites.apply {
            layoutManager = LinearLayoutManager(
                view.context,
                RecyclerView.VERTICAL,
                false
            )
            this.adapter = favoritesRecyclerAdapter
        }

        Log.d("fav_count", "is computing ${binding.favorites.isComputingLayout}")
        Log.d("fav_count", "fav count from profil = $favCount")
        Log.d("fav_count", "favorite list size is: ${favoriteList.size}")

    }
}
