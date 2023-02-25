package example.todoapp.lite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.*
import example.todoapp.lite.common.RootContent2

fun main() {
    application {
        val icon = painterResource("images/Logo3_1.png")
        if(isTraySupported) {
            Tray(
                icon = icon,
                menu = {
                    Item("Quit App", onClick = ::exitApplication)
                }
            )
        }
        Window(
            onCloseRequest = ::exitApplication,
            title = "DLVC Desktop",
            state = rememberWindowState(
                position = WindowPosition(alignment = Alignment.Center),
            ),
            icon = icon
        ) {
            MaterialTheme {
                RootContent2(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
