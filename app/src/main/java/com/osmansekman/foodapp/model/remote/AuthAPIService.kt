package com.osmansekman.foodapp.model.remote

import com.osmansekman.foodapp.model.entity.User
import com.osmansekman.foodapp.model.entity.mealadd.MealAddRequest
import com.osmansekman.foodapp.model.entity.mealadd.MealAddResponse
import com.osmansekman.foodapp.model.entity.order.OrderAddRequest
import com.osmansekman.foodapp.model.entity.order.OrderAddResponse
import com.osmansekman.foodapp.model.entity.order.OrderResponse
import com.osmansekman.foodapp.model.entity.profile.UserRequest
import com.osmansekman.foodapp.model.entity.profile.UserResponse
import com.osmansekman.foodapp.model.entity.restaurantadd.RestaurantAddRequest
import com.osmansekman.foodapp.model.entity.restaurantadd.RestaurantAddResponse
import retrofit2.Response
import retrofit2.http.*

interface AuthAPIService {

    @POST("a/restaurant")
    suspend fun postRestaurant(@Body request: RestaurantAddRequest): Response<RestaurantAddResponse>

    @POST("a/restaurant/{restaurantId}/meal")
    suspend fun postMeal(
        @Path("restaurantId") restaurantId: String,
        @Body request: MealAddRequest
    ): Response<MealAddResponse>

    @POST("a/order")
    suspend fun postOrder(@Body request: OrderAddRequest): Response<OrderAddResponse>

    @GET("a/order")
    suspend fun getOrders(): Response<OrderResponse>

    @PUT("auth/updateDetails")
    suspend fun updateUser(@Body request : UserRequest) : Response<User>

    @GET("auth/profile")
    suspend fun getUser() : Response<UserResponse>

}