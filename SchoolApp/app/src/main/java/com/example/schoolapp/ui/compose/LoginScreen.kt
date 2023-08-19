package com.example.schoolapp.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.schoolapp.ui.viewmodels.LoginViewModel
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val loginState by viewModel.loginState.collectAsState()

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = loginState.username,
                    onValueChange = { viewModel.updateUsername(it) },
                    label = { Text(text = "Username") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = loginState.password,
                    onValueChange = { viewModel.updatePassword(it) },
                    label = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.performLogin(
                            loginState.username,
                            loginState.password
                        )
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Login")
                }
                if (loginState.error.isNotEmpty()) {
                    Text(
                        text = loginState.error,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun LoginApp() {
    val viewModel: LoginViewModel = viewModel()
    LoginScreen(viewModel = viewModel)
}
