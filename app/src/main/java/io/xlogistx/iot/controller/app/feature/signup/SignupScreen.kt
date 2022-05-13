package io.xlogistx.iot.controller.app.feature.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.xlogistx.iot.controller.app.theme.ThemedPreview

/**
 * @author Ryan Simon
 */
@Composable
fun SignupScreen() {
    SignupContent()
}

@Composable
private fun SignupContent() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Signup")
    }
}

@Preview
@Composable
private fun SignupContentPreview() {
    ThemedPreview {
        SignupContent()
    }
}
