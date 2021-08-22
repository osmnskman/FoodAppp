package com.osmansekman.foodapp.ui.mealadd

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.osmansekman.foodapp.model.ApiRepository
import com.osmansekman.foodapp.model.entity.mealadd.MealAddRequest
import com.osmansekman.foodapp.model.entity.mealadd.MealAddResponse
import com.osmansekman.foodapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealAddViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val apiRepository: ApiRepository
) : ViewModel() {

    fun addMeal(
        restaurantId: String,
        name: String,
        imageUrl: String,
        price: String,
        ingredients: List<String>
    ): LiveData<Resource<MealAddResponse>> {
        val request = MealAddRequest(name, imageUrl, price, ingredients)
        return apiRepository.postMeal(restaurantId, request)
    }

}