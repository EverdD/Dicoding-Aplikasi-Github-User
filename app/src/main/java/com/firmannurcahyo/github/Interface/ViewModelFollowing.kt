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

//Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

class ViewModelFollowing : ViewModel() {

    companion object {
        private const val TAG = "Following"
    }

    private val _listFollowing = MutableLiveData<List<User>>()
    val listFollowing: LiveData<List<User>> = _listFollowing

    fun setListFollowing(username: String) {
        Token.getTokenService().getFollowing(username).enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    _listFollowing.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}