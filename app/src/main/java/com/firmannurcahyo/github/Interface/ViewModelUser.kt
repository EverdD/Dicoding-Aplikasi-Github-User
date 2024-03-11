package com.firmannurcahyo.github.Interface

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.firmannurcahyo.github.API.Token
import com.firmannurcahyo.github.DB.UserFavorite
import com.firmannurcahyo.github.DB.FavoriteDao
import com.firmannurcahyo.github.DB.DatabaseUser
import com.firmannurcahyo.github.DM.DataUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser(application: Application) : AndroidViewModel(application) {

    companion object {
        private const val TAG = "UserDetailActivity"
    }

    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
    val user = MutableLiveData<DataUser>()

    private var userDao: FavoriteDao?
    private var userDb: DatabaseUser? = DatabaseUser.getDatabase(application)

    init {
        userDao = userDb?.favoriteUserDao()
    }

    fun setUserDetail(username: String) {
        Token.getTokenService().getUserDetail(username).enqueue(object : Callback<DataUser> {
            override fun onResponse(
                call: Call<DataUser>, response: Response<DataUser>
            ) {
                if (response.isSuccessful) {
                    user.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<DataUser>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

    fun addToFavorite(username: String, id: Int, avatarUrl: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = UserFavorite(
                username, id, avatarUrl
            )
            userDao?.addToFavorite(user)
        }
    }

    suspend fun checkUser(id: Int) = userDao?.checkUser(id)

    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
    fun getUserDetail(): LiveData<DataUser> {
        return user
    }

    fun removeFromFavorite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao?.removeFromFavorite(id)
        }
    }
}