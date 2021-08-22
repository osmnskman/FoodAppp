package com.osmansekman.foodapp.model

import com.osmansekman.foodapp.model.entity.login.LoginRequest
import com.osmansekman.foodapp.model.entity.mealadd.MealAddRequest
import com.osmansekman.foodapp.model.entity.order.OrderAddRequest
import com.osmansekman.foodapp.model.entity.profile.UserRequest
import com.osmansekman.foodapp.model.entity.register.RegisterRequest
import com.osmansekman.foodapp.model.entity.restaurantadd.RestaurantAddRequest
import com.osmansekman.foodapp.model.local.LocalDataSource
import com.osmansekman.foodapp.model.remote.AuthRemoteDataSource
import com.osmansekman.foodapp.model.remote.RemoteDataSource
import com.osmansekman.foodapp.utils.performAuthTokenNetworkOperation
import com.osmansekman.foodapp.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var authRemoteDataSource: AuthRemoteDataSource,
    private var localDataSource: LocalDataSource
) {

    fun login(request: LoginRequest) = performAuthTokenNetworkOperation(
        call = {
            remoteDataSource.postLogin(request)
        },
        saveToken = {
            localDataSource.saveToken(it)
        }
    )

    fun register(request: RegisterRequest) = performAuthTokenNetworkOperation(
        call = {
            remoteDataSource.postRegister(request)
        },
        saveToken = {
            localDataSource.saveToken(it)
        }
    )

    fun getRestaurants() =
        performNetworkOperation {
            remoteDataSource.getRestaurants()
        }

    fun getRestaurantById(id: String) =
        performNetworkOperation {
            remoteDataSource.getRestaurantById(id)
        }

    fun postRestaurant(restaurantAddRequest: RestaurantAddRequest) =
        performNetworkOperation {
            authRemoteDataSource.postRestaurant(request = restaurantAddRequest)
        }

    fun getMealById(id: String) =
        performNetworkOperation {
            remoteDataSource.getMealById(id)
        }


    fun postMeal(restaurantId: String, mealAddRequest: MealAddRequest) =
        performNetworkOperation {
            authRemoteDataSource.postMeal(restaurantId, request = mealAddRequest)
        }

    fun getRestaurantByCuisine(cuisine: String) =
        performNetworkOperation {
            remoteDataSource.getRestaurantsByCuisine(cuisine)
        }


    fun getOrder() =
        performNetworkOperation {
            authRemoteDataSource.getOrders()
        }

    fun getUser() = performNetworkOperation {
        authRemoteDataSource.getUser()
    }

    fun updateUser(user : UserRequest) = performNetworkOperation {
        authRemoteDataSource.updateUser(request = user)
    }

    fun postOrder(orderAddRequest: OrderAddRequest) =
        performNetworkOperation {
            authRemoteDataSource.postOrder(orderAddRequest)
        }

    fun logOut() {
        localDataSource.saveToken("")
    }

}
