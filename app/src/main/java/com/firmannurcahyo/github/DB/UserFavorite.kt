package com.firmannurcahyo.github.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite_user")
data class UserFavorite(
    @ColumnInfo(name = "login") val login: String,
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "avatar_url") val avatar_url: String
) : Serializable