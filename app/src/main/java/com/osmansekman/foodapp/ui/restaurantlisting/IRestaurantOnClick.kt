package com.osmansekman.foodapp.ui.restaurantlisting

import com.osmansekman.foodapp.model.entity.restaurant.Restaurant

interface IRestaurantOnClick {
    fun onClick(restaurant: Restaurant)
}