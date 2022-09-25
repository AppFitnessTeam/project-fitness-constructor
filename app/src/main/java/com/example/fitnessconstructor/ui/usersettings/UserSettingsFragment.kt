package com.example.fitnessconstructor.ui.usersettings

import android.os.Bundle
import android.view.View
import com.example.fitnessconstructor.databinding.FragmentUserSettingsBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSettingsFragment :
    BaseFragment<FragmentUserSettingsBinding>(FragmentUserSettingsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        with(binding){
            userLayout.stressTestButton.setOnClickListener { toastBlock() }
            saveUserButton.setOnClickListener { toastBlock() }
        }
    }
}