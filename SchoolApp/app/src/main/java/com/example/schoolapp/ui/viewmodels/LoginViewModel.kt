package com.example.schoolapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schoolapp.data.model.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun performLogin(username: String, password: String) {
        viewModelScope.launch {
            // Simulate login process
            if (username == "user" && password == "password") {
                _loginState.emit(LoginState(success = true))
            } else {
                _loginState.emit(LoginState(error = "Invalid credentials"))
            }
        }
    }

    fun updateUsername(newUsername: String) {
        val newState = loginState.value.copy(username = newUsername)
        _loginState.value = newState
    }

    fun updatePassword(newPassword: String) {
        val newState = loginState.value.copy(password = newPassword)
        _loginState.value = newState
    }
}
