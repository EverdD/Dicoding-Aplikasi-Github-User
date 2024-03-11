package com.firmannurcahyo.github.API

import com.firmannurcahyo.github.DM.DataUser
import com.firmannurcahyo.github.DM.User
import com.firmannurcahyo.github.DM.Responses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TokenService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(@Query("q") query: String): Call<Responses>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(@Path("username") username: String): Call<DataUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(@Path("username") username: String): Call<List<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(@Path("username") username: String): Call<List<User>>
}