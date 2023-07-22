package com.xplpc.runner.android.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import com.xplpc.client.Client
import com.xplpc.message.Param
import com.xplpc.message.Request
import com.xplpc.runner.common.App

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                App(onGetBatteryLevel = { callback ->
                    val request = Request(
                        "platform.battery.level",
                        Param("suffix", "%")
                    )

                    Client.call<String>(request) { response ->
                        callback(response)
                    }
                })
            }
        }
    }
}
