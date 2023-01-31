package com.example.a17_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a17_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val service = RetrofitClient.createPostService()
        val service = RetrofitClient.createService(PostService::class.java)
        val call: Call<List<PostEntity>> = service.list()

        call.enqueue(object : Callback<List<PostEntity>> {
            override fun onResponse(
                call: Call<List<PostEntity>>,
                response: Response<List<PostEntity>>
            ) {
                val list = response.body()
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {

            }
        })

        val service2 = RetrofitClient.createService(UserService::class.java)
        val call2: Call<List<UserEntity>> = service2.list()

        call2.enqueue(object : Callback<List<UserEntity>> {
            override fun onResponse(
                call: Call<List<UserEntity>>,
                response: Response<List<UserEntity>>
            ) {
                val list = response.body()
                if (list != null) {
                    val names = ArrayList<String>()
                    for (element in list) {
                        names.add(element.name)
                    }
                    binding.listView.adapter =
                        ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, names)
                }
            }

            override fun onFailure(call: Call<List<UserEntity>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}

