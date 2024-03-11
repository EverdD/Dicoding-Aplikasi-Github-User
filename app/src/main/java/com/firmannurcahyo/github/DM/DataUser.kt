package com.firmannurcahyo.github.DM

// Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
data class DataUser(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val followers_url: String,
    val following_url: String,
    val repos_url: String,
    val following: Int,
    val followers: Int,
    val public_repos: Int,
    val name: String,
    val company: String,
    val location: String
)
