package com.example.fitnessconstructor

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //navigate from splash screen to the Workout List frag
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_workoutListFragment)
            }, 2000)
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


}