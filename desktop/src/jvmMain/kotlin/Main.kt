import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        val scope = rememberCoroutineScope()

        MaterialTheme {
            var loginText by remember { mutableStateOf("Press Button To Execute") }

            // TODO: when lib for desktop works
            /*
            val request = Request(
                "platform.battery.level",
                Param("suffix", "%")
            )
            */

            Button(onClick = {
                // TODO: when lib for desktop works
                /*
                Client.call<String>(request) { response ->
                    loginText = response ?: ""

                    scope.launch {
                        loginText = getString(R.string.battery_level_result, response)
                    }
                }
                */

                loginText = "not implemented in desktop"
            }) {
                Text(loginText)
            }

            // TODO: how to create single screen?
            //App()
        }
    }
}
