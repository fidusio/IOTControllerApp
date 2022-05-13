package io.xlogistx.iot.controller.app.feature.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.xlogistx.iot.controller.app.theme.ThemedPreview

/**
 * @author Ryan Simon
 */
sealed class LoginState {
  object Idle : LoginState()
  object Loading : LoginState()
  data class Error(val message: String) : LoginState()
  data class Success(val message: String) : LoginState()
}

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginClick: (email: String, password: String) -> Unit,
    onSignupClick: () -> Unit
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    when (state) {
        LoginState.Idle -> {
            LoginContent(
                email = email.value,
                password = password.value,
                onEmailChange = {
                    email.value = it
                },
                onPasswordChange = {
                    password.value = it
                },
                onLoginClick = onLoginClick,
                onSignupClick = onSignupClick
            )
        }
        is LoginState.Error -> TODO()
        LoginState.Loading -> {
            CircularProgressIndicator()
        }
        is LoginState.Success -> TODO()
    }
}

@Composable
private fun LoginContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: (email: String, password: String) -> Unit,
    onSignupClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = email,
                onValueChange = onEmailChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = onPasswordChange,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = onSignupClick) {
                Text("Signup")
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = { onLoginClick(email, password) }) {
                Text("Login")
            }
        }
    }

}

@Preview(device = PIXEL_4)
@Composable
fun LoginContentPreview() {
    ThemedPreview {
        LoginContent(
            email = "",
            password = "",
            onEmailChange = {},
            onPasswordChange = {},
            onSignupClick = {},
            onLoginClick = { email: String, password: String -> }
        )
    }
}
