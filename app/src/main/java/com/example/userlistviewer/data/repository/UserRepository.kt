package com.example.userlistviewer.data.repository

import com.example.userlistviewer.data.model.User
import com.example.userlistviewer.data.remote.ApiService

class UserRepository(private val apiService: ApiService) {
    suspend fun fetchUsers(): List<User> = apiService.getUsers()
}
