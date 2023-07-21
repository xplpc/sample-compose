package com.xplpc.runner.android.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.xplpc.android.R

import com.xplpc.client.Client
import com.xplpc.message.Param
import com.xplpc.message.Request
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()

            MaterialTheme {
                var loginText by remember { mutableStateOf("Press Button To Execute") }

                val request = Request(
                    "platform.battery.level",
                    Param("suffix", "%")
                )

                Button(onClick = {
                    Client.call<String>(request) { response ->
                        loginText = response ?: ""

                        scope.launch {
                            loginText = getString(R.string.battery_level_result, response)
                        }
                    }
                }) {
                    Text(loginText)
                }

                // TODO: how to create single screen?
                //App()
            }
        }
    }
}