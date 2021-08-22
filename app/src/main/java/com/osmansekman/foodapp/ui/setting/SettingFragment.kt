package com.osmansekman.foodapp.ui.setting

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.osmansekman.foodapp.R
import com.osmansekman.foodapp.databinding.FragmentSettingsBinding
import com.osmansekman.foodapp.model.entity.User
import com.osmansekman.foodapp.model.entity.profile.UserRequest
import com.osmansekman.foodapp.ui.profile.ProfileFragment
import com.osmansekman.foodapp.utils.Resource
import com.osmansekman.foodapp.utils.gone
import com.osmansekman.foodapp.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment() {
    private lateinit var _binding: FragmentSettingsBinding
    private val viewModel: SettingViewModel by viewModels()
    private var image: Int = R.mipmap.no_data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        addListeners()
    }

    private fun initViews() {
        viewModel.getUser().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {
                    _binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    setField(response.data?.user)
                    isSettingVisible(true)
                }
                Resource.Status.ERROR -> {
                    isSettingVisible(false)
                }
            }
        })
    }

    private fun setField(user: User?) {
        _binding.nameEditText.setText(user?.name)
        _binding.mailEditText.setText(user?.email)
        _binding.addressEditText.setText(user?.address)
        _binding.phoneNumberEditText.setText(user?.phone)

        image = ProfileFragment.getImageResource(user?.profileImage)
        _binding.avatarImageView.setImageResource(ProfileFragment.getImageResource(user?.profileImage))
    }

    private fun addListeners() {
         _binding.updateButton.setOnClickListener { updateUser() }
        _binding.backImageView.setOnClickListener { findNavController().popBackStack() }
    }

    private fun updateUser() {
        val name = _binding.nameEditText.text.toString()
        val mail = _binding.mailEditText.text.toString()
        val phone = _binding.phoneNumberEditText.text.toString()
        val address = _binding.addressEditText.text.toString()

        val user = UserRequest(mail, name, address, phone, image.toString())
        viewModel.updateUser(user).observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {
                    _binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
                    isSettingVisible(true)
                }
                Resource.Status.ERROR -> {
                    isSettingVisible(false)
                }
            }
        })
    }

    private fun isSettingVisible(isVisible: Boolean) {
        _binding.progressBar.gone()
        _binding.container.isVisible = isVisible
        if (isVisible.not()) {
            AlertDialog.Builder(context)
                .setTitle(getString(R.string.Error))
                .setMessage(getString(R.string.problem))
                .setPositiveButton("Cancel") { _, _ ->
                    findNavController().popBackStack()
                }.show()
        }
    }
}

