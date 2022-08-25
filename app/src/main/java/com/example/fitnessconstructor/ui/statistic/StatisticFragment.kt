package com.example.fitnessconstructor.ui.statistic

import com.example.fitnessconstructor.databinding.FragmentStatisticBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticFragment :
    BaseFragment<FragmentStatisticBinding>(FragmentStatisticBinding::inflate) {

    companion object {

        @JvmStatic
        fun newInstance() = StatisticFragment()
    }
}