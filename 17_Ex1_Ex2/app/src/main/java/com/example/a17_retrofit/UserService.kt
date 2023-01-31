package com.example.a17_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun list(): Call<List<UserEntity>>
}