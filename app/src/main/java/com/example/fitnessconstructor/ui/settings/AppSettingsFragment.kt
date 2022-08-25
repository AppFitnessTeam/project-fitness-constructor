package com.example.fitnessconstructor.ui.settings

import com.example.fitnessconstructor.databinding.FragmentAppSettingsBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppSettingsFragment :
    BaseFragment<FragmentAppSettingsBinding>(FragmentAppSettingsBinding::inflate) {

    companion object {

        @JvmStatic
        fun newInstance() = AppSettingsFragment()
    }
}