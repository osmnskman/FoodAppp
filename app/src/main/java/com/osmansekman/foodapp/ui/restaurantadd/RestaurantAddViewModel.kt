package com.osmansekman.foodapp.ui.restaurantadd

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.osmansekman.foodapp.model.ApiRepository
import com.osmansekman.foodapp.model.entity.restaurantadd.RestaurantAddRequest
import com.osmansekman.foodapp.model.entity.restaurantadd.RestaurantAddResponse
import com.osmansekman.foodapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantAddViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val apiRepository: ApiRepository
) : ViewModel() {

    fun addRestaurant(
        name: String,
        cuisine: String,
        deliveryInfo: String,
        deliveryTime: String,
        imageUrl: String,
        address: String,
        district: String,
        minDeliveryFee: String,
        paymentMethods: String,
        phone: String,
        website: String,
    ): LiveData<Resource<RestaurantAddResponse>> {

        val request = RestaurantAddRequest(
            name, cuisine, deliveryInfo, deliveryTime,
            imageUrl, address, district, minDeliveryFee, paymentMethods, phone, website
        )

        return apiRepository.postRestaurant(request)

    }


}