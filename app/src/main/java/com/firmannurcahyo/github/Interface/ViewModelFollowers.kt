package com.firmannurcahyo.github.Interface

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firmannurcahyo.github.API.Token
import com.firmannurcahyo.github.DM.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

class ViewModelFollowers : ViewModel() {

    companion object {
        private const val TAG = "FollowersViewModel"
    }

    private val _listFollowers = MutableLiveData<List<User>>()
    val listFollowers: LiveData<List<User>> get() = _listFollowers

    fun setListFollowers(username: String) {
        Token.getTokenService().getFollowers(username).enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    _listFollowers.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    // Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
    @JvmName("getListFollowersLiveData")
    fun getListFollowers(): LiveData<List<User>> {
        return listFollowers
    }
}