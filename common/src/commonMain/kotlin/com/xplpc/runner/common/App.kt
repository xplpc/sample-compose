package com.xplpc.runner.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import kotlinx.coroutines.launch


@Composable
fun App(onGetBatteryLevel: ((String?) -> Unit) -> Unit = {}) {
    val scope = rememberCoroutineScope()

    var loginText by remember { mutableStateOf("Press Button To Execute") }

    Button(onClick = {
        onGetBatteryLevel { response ->
            scope.launch {
                // TODO: use common resources to format string
                loginText = "Battery Level: $response"
            }
        }
    }) {
        Text(loginText)
    }
}
