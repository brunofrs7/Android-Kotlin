package com.example.a16_room

import android.content.Context
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

class UserRepository(context: Context) {

    private val userDatabase = UserDatabase.getDatabase(context).userDAO()

    fun insert(user: UserModel): Long {
        return userDatabase.insert(user)
    }

    fun update(user: UserModel): Int {
        return userDatabase.update(user)
    }

    fun delete(user: UserModel): Int {
        return userDatabase.delete(user)
    }

    fun get(id: Int): UserModel {
        return userDatabase.get(id)
    }

    fun getAll(): List<UserModel> {
        return userDatabase.getAll()
    }
}