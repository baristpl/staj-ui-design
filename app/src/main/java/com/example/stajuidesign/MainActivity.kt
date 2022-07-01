package com.example.stajuidesign

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.stajuidesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(setOf(R.id.onboard_des, R.id.home_fragment_des))

        setupActionBar(navController, appBarConfiguration)
        setupBottomNavigatonBar(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            val bottom_nav = binding.bottomNav
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            val window: Window = window

            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            when (dest) {
                resources.getResourceName(R.id.onboard_des) -> dest.apply {
                    toolbar.setBackgroundResource(R.color.background_white)
                    bottom_nav.visibility = View.GONE
                    window.setStatusBarColor(resources.getColor(R.color.background_white))
                    binding.notificationIcon.visibility = View.GONE
                }

                resources.getResourceName(R.id.login_fragment_des) -> dest.apply {
                    toolbar.setBackgroundResource(R.color.white)
                    bottom_nav.visibility = View.GONE
                    window.setStatusBarColor(resources.getColor(R.color.white))
                    binding.notificationIcon.visibility = View.GONE
                }
                resources.getResourceName(R.id.home_fragment_des) -> dest.apply {
                    toolbar.setBackgroundResource(R.color.theme_color)
                    bottom_nav.visibility = View.VISIBLE
                    window.setStatusBarColor(resources.getColor(R.color.theme_color))
                    binding.notificationIcon.visibility = View.VISIBLE
                }


                else -> dest.apply {
                    toolbar.setBackgroundResource(R.color.theme_color)
                    bottom_nav.visibility = View.VISIBLE
                    window.setStatusBarColor(resources.getColor(R.color.theme_color))
                    binding.notificationIcon.visibility = View.GONE
                }
            }

        }

    }

    private fun setupBottomNavigatonBar(navController: NavController) {
        val bottom_nav = binding.bottomNav
        val navHomeOpt = NavOptions.Builder().setPopUpTo(R.id.home_fragment_des, true, false).build()
        val navProfileOpt = NavOptions.Builder().setPopUpTo(R.id.profile_fragment_des, true, false).build()

        bottom_nav.setupWithNavController(navController)
        bottom_nav.setOnItemSelectedListener {
            if (it.itemId == R.id.home_fragment_des) navController.navigate(R.id.home_fragment_des, null, navHomeOpt)
            else navController.navigate(R.id.profile_fragment_des, null, navProfileOpt)
             return@setOnItemSelectedListener true
        }
    }

    private fun setupActionBar(
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }
}