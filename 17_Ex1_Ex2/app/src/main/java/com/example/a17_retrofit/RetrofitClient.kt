package com.example.a17_retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <S> createService(service: Class<S>): S {
            return getRetrofitInstance().create(service)
        }

        /*fun createPostService(): PostService {
            return getRetrofitInstance().create(PostService::class.java)
        }

        fun createUserService(): UserService {
            return getRetrofitInstance().create(UserService::class.java)
        }*/
    }
}