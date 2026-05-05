package com.example.userlistviewer.data.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val address: Address,
    val company: Company
)

data class Address(
    val city: String
)

data class Company(
    val name: String
)
