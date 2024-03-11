package com.firmannurcahyo.github.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

@Dao
interface FavoriteDao {
    @Insert
    fun addToFavorite(favoriteUser: UserFavorite)

    @Query("SELECT * FROM favorite_user")
    fun getFavoriteUser(): LiveData<List<UserFavorite>>

    @Query("SELECT count(*) FROM favorite_user WHERE favorite_user.id = :id")
    fun checkUser(id: Int): Int

    @Query("DELETE FROM favorite_user WHERE favorite_user.id = :id")
    fun removeFromFavorite(id: Int): Int
}