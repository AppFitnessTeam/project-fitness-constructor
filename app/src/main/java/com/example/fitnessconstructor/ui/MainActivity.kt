package com.example.fitnessconstructor.ui

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Executors


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Splash Screen launch
        splashScreenLaunch()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bottom action bar
        bottomActionBarLaunch()

        //remove action bar while launch app
        supportActionBar?.hide()
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top_bar, menu)
        return true
    }

    private fun bottomActionBarLaunch() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragment_container_view
        ) as NavHostFragment
        navController = navHostFragment.navController

        // Setup the bottom navigation view with navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setupWithNavController(navController)

        // Setup the ActionBar with navController and 3 top level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.workoutListFragment, R.id.statisticFragment, R.id.appSettingsFragment)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun splashScreenLaunch() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()

            splashScreen.setKeepOnScreenCondition { true }
            Executors.newSingleThreadExecutor().execute {
                Thread.sleep(0)
                splashScreen.setKeepOnScreenCondition { false }
            }
            splashScreen.setOnExitAnimationListener { splashScreenProvider ->
                ObjectAnimator.ofFloat(
                    splashScreenProvider.view,
                    View.TRANSLATION_Y,
                    0f, -splashScreenProvider.view.height.toFloat()
                ).apply {
                    duration = 500
                    interpolator = AnticipateInterpolator() //with acceleration
                    doOnEnd { splashScreenProvider.remove() }
                }.start()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

}