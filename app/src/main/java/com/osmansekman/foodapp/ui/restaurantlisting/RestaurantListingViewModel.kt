package com.osmansekman.foodapp.ui.restaurantlisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.osmansekman.foodapp.model.ApiRepository
import com.osmansekman.foodapp.model.entity.restaurant.Restaurant
import com.osmansekman.foodapp.model.entity.restaurant.RestaurantListResponse
import com.osmansekman.foodapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantListingViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    var restaurantList: List<Restaurant>? = null

    fun getRestaurants(): LiveData<Resource<RestaurantListResponse>> =
        apiRepository.getRestaurants()


    fun getRestaurantByCuisine(cuisine: String): LiveData<Resource<RestaurantListResponse>> =
        apiRepository.getRestaurantByCuisine(cuisine)

    fun searchTextOnRestaurantList(text: String?): List<Restaurant>? {
        if (text.isNullOrEmpty())
            return restaurantList

        val filterList: MutableList<Restaurant> = mutableListOf()
        restaurantList?.forEach { restaurant ->
            if (restaurant.name.contains(text, true))
                filterList.add(restaurant)
            else if (restaurant.district.contains(text, true))
                filterList.add(restaurant)
        }
        return filterList
    }

}