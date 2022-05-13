package io.xlogistx.iot.controller.app

/**
 * @author Ryan Simon
 */
sealed class Screen {
    data class Login(val email: String, val password: String) : Screen()
    object Signup : Screen()
}
