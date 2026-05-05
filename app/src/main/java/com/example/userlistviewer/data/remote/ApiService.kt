package com.example.userlistviewer.data.remote

import com.example.userlistviewer.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
