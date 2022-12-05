package com.example.a16_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [UserModel::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {
        private lateinit var INSTANCE: UserDatabase

        fun getDatabase(context: Context): UserDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(UserDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "userDB")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //IMPLEMENTAR O NECESSÁRIO
            }

        }
    }
}


