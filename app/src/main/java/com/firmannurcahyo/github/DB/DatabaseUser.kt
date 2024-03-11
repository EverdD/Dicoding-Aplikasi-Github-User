package com.firmannurcahyo.github.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserFavorite::class], version = 1)
abstract class DatabaseUser : RoomDatabase() {

    abstract fun favoriteUserDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseUser? = null

        fun getDatabase(context: Context): DatabaseUser {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, DatabaseUser::class.java, "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}