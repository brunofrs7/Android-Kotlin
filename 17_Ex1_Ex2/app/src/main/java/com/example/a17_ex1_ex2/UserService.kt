package com.example.a17_ex1_ex2

import retrofit2.Call
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun list(): Call<List<UserEntity>>
}