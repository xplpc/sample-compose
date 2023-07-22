import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.xplpc.runner.common.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App(onGetBatteryLevel = { callback ->
            callback.invoke("NOT IMPLEMENTED YET!")
        })
    }
}
