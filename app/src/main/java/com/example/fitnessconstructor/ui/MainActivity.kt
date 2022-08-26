package com.example.fitnessconstructor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessconstructor.*
import com.example.fitnessconstructor.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bottom navigation
        if (savedInstanceState == null) {
            initBottomNavigation()
        }
        //remove action bar while launch app
        supportActionBar?.hide()

    }


    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_navigation_lable_one -> {

                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmentContainerView, WorkoutListFragment())
                        .commit()
                    true
                }

                R.id.bottom_navigation_lable_two -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmentContainerView, AppSettingsFragment())
                        .commit()
                    true

                }
                R.id.bottom_navigation_lable_three -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmentContainerView, WorkoutFragment())
                        .commit()
                    true

                }
                else -> true
            }
        }
        //default view
        binding.bottomNavigationView.selectedItemId = R.id.bottom_navigation_lable_one
    }
}