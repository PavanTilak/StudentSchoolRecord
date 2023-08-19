package com.example.schoolapp.data.model

data class LoginState(
    val username: String = "",
    val password: String = "",
    val success: Boolean = false,
    val error: String = ""
)
