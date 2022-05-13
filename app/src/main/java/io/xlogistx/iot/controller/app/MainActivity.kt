package io.xlogistx.iot.controller.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.xlogistx.iot.controller.app.feature.login.LoginScreen
import io.xlogistx.iot.controller.app.feature.login.LoginState
import io.xlogistx.iot.controller.app.feature.signup.SignupScreen
import io.xlogistx.iot.controller.app.theme.IOTControllerAppTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navStack: Stack<Screen> = Stack<Screen>().apply {
            push(Screen.Login(email = "", password = ""))
        }

        setContent {
            IOTControllerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val currentScreen = remember {
                        mutableStateOf<Screen>(navStack.peek())
                    }

                    onBackPressedDispatcher.addCallback {
                        try {
                            navStack.pop()
                            currentScreen.value = navStack.peek()
                        } catch (e: EmptyStackException) {
                            finish()
                        }
                    }

                    when (currentScreen.value) {
                        is Screen.Login -> {
                            LoginScreen(
                                state = LoginState.Idle,
                                onLoginClick = { email: String, password: String ->
                                    // TODO
                                },
                                onSignupClick = {
                                    navStack.push(Screen.Signup)
                                    currentScreen.value = navStack.peek()
                                }
                            )
                        }
                        Screen.Signup -> {
                            SignupScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IOTControllerAppTheme {
        Greeting("Android")
    }
}