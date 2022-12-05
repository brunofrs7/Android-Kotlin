package com.example.a16_room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(application.applicationContext)

    private val listUsers = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> = listUsers

    private val userModel = MutableLiveData<UserModel>()
    var user: LiveData<UserModel> = userModel

    private var changes = MutableLiveData<Long>()
    var newChange: LiveData<Long> = changes

    fun getAll() {
        listUsers.value = repository.getAll()
    }

    fun get(id: Int) {
        userModel.value = repository.get(id)
    }

    fun insert(username: String, password: String) {
        val model = UserModel().apply {
            this.username = username
            this.password = password
        }
        changes.value = repository.insert(model)
    }

    fun update(id: Int, username: String, password: String) {
        val model = UserModel().apply {
            this.id = id
            this.username = username
            this.password = password
        }
        changes.value = repository.update(model).toLong()
    }

    fun delete(id: Int) {
        val model = UserModel().apply {
            this.id = id
        }
        changes.value = repository.delete(model).toLong()
    }

}