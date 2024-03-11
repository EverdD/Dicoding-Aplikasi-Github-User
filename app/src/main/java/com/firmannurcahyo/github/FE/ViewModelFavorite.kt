package com.firmannurcahyo.github.FE

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.firmannurcahyo.github.DB.DatabaseUser
import com.firmannurcahyo.github.DB.FavoriteDao
import com.firmannurcahyo.github.DB.UserFavorite
// Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

class ViewModelFavorite(application: Application) : AndroidViewModel(application) {

    private var userDao: FavoriteDao? = null
    private var userDb: DatabaseUser? = DatabaseUser.getDatabase(application)

    init {
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<UserFavorite>>? {
        return userDao?.getFavoriteUser()
    }
}