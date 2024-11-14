package com.example.a16_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {

    @Insert
    fun insert(user: UserModel): Long

    @Update
    fun update(user: UserModel): Int

    @Delete
    fun delete(user: UserModel): Int

    @Query("SELECT * FROM User WHERE id = :id")
    fun get(id: Int): UserModel

    @Query("SELECT * FROM User")
    fun getAll(): List<UserModel>
}
