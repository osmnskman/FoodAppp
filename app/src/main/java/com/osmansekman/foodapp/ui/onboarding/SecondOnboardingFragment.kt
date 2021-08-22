package com.osmansekman.foodapp.ui.Onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.osmansekman.foodapp.databinding.FragmentSecondOnboardingBinding

class SecondOnBoardingFragment : Fragment() {
    private var _binding: FragmentSecondOnboardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()

        return view
    }

    private fun mainFunc() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}