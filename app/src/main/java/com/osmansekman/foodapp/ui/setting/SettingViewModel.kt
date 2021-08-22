package com.osmansekman.foodapp.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.osmansekman.foodapp.model.ApiRepository
import com.osmansekman.foodapp.model.entity.User
import com.osmansekman.foodapp.model.entity.profile.UserRequest
import com.osmansekman.foodapp.model.entity.profile.UserResponse
import com.osmansekman.foodapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    fun getUser(): LiveData<Resource<UserResponse>> = apiRepository.getUser()

    fun updateUser(userRequest: UserRequest): LiveData<Resource<User>> =
        apiRepository.updateUser(userRequest)

}