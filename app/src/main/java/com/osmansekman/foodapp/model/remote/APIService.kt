package com.osmansekman.foodapp.model.remote

import com.osmansekman.foodapp.model.entity.login.LoginRequest
import com.osmansekman.foodapp.model.entity.login.LoginResponse
import com.osmansekman.foodapp.model.entity.meal.MealResponse
import com.osmansekman.foodapp.model.entity.register.RegisterRequest
import com.osmansekman.foodapp.model.entity.register.RegisterResponse
import com.osmansekman.foodapp.model.entity.restaurant.RestaurantListResponse
import com.osmansekman.foodapp.model.entity.restaurant.RestaurantResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @GET("a/restaurant")
    suspend fun getRestaurants(): Response<RestaurantListResponse>

    @GET("a/restaurant/cuisine/{cuisineName}")
    suspend fun getRestaurantsByCuisine(@Path("cuisineName") cuisine: String): Response<RestaurantListResponse>

    @GET("a/restaurant/{id}")
    suspend fun getRestaurantById(@Path("id") id: String): Response<RestaurantResponse>

    @GET("a/meal/{id}")
    suspend fun getMealById(@Path("id") id: String): Response<MealResponse>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>


}