package com.firmannurcahyo.github

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firmannurcahyo.github.API.Token
import com.firmannurcahyo.github.DM.User
import com.firmannurcahyo.github.DM.Responses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
class MainViewModel : ViewModel() {

    companion object {
        private const val TAG = "MainActivity"
    }

    val listUsers = MutableLiveData<List<User>>()

    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
    fun setSearchUsers(query: String) {
        Token.getTokenService().getSearchUsers(query).enqueue(object : Callback<Responses> {
            override fun onResponse(
                call: Call<Responses>, response: Response<Responses>
            ) {
                if (response.isSuccessful) {
                    listUsers.postValue(response.body()?.items)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Responses>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
    fun getSearchUsers(): LiveData<List<User>> {
        return listUsers
    }
}