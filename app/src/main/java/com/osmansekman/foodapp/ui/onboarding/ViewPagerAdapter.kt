package com.osmansekman.foodapp.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.osmansekman.foodapp.ui.Onboarding.FirstOnBoardingFragment
import com.osmansekman.foodapp.ui.Onboarding.SecondOnBoardingFragment
import com.osmansekman.foodapp.ui.Onboarding.ThirdOnBoardingFragment

private const val FRAGMENT_COUNT = 3

class ViewPagerAdapter(requireActivity: FragmentActivity) : FragmentStateAdapter(requireActivity) {


    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstOnBoardingFragment()
            1 -> SecondOnBoardingFragment()
            2 -> ThirdOnBoardingFragment()
            else -> FirstOnBoardingFragment()
        }
    }

}