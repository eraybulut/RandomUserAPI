package com.eray.randomuserapi.data

import com.eray.randomuserapi.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

   // "results=10"
    @GET(".")
    fun getUsers(@Query("results") results:Int):Call<UserResponse>
}