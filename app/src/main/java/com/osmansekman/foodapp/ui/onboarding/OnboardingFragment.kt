package com.osmansekman.foodapp.ui.Onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.osmansekman.foodapp.R
import com.osmansekman.foodapp.databinding.FragmentOnboardingBinding
import com.osmansekman.foodapp.utils.ViewPagerAdapter

class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()

        return view
    }

    private fun mainFunc() {
        val adapter = ViewPagerAdapter(requireActivity())

        binding.viewPager2.adapter = adapter
        binding.wormDots.setViewPager2(binding.viewPager2)


        binding.cardViewButton.setOnClickListener {

            //Eğer son onboarding sayfasına geldiyse diye kontrol ediyoruz.
            if (binding.viewPager2.currentItem == adapter.itemCount - 1) {
                onBoardingFinished().apply {
                    findNavController().navigate(R.id.action_onBoardingFragment_to_loginAndSignupFragment)
                }
            } else {
                binding.viewPager2.currentItem = binding.viewPager2.currentItem + 1
            }

        }
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onboarding1", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("finished", true)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}