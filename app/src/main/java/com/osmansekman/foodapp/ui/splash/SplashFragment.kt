package com.osmansekman.foodapp.ui.splash

import android.animation.Animator
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.osmansekman.foodapp.R
import com.osmansekman.foodapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()
        return view
    }

    private fun mainFunc() {
        binding.splashAnimation.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Log.v("Animation","Started")
            }

            override fun onAnimationEnd(animation: Animator?) {
                if(!isOnboardingFinished()) {
                    findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
                }else{
                    findNavController().navigate(R.id.action_splashFragment_to_loginAndSignupFragment)
                }
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.v(getString(R.string.animation),getString(R.string.canceled))
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.v(getString(R.string.animation),getString(R.string.repeated))
            }
        })
    }

    private fun isOnboardingFinished(): Boolean {
        //To set up a shared preferences structure and check for Onboarding to show once after running
        val sharedPref = requireActivity().getSharedPreferences("onboarding1", Context.MODE_PRIVATE)
        return sharedPref.getBoolean(getString(R.string.finished), false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
