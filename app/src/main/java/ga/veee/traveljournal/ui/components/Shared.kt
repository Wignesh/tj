package ga.veee.traveljournal.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ga.veee.traveljournal.ui.theme.Gunmetal

@Composable
fun SystemUi(hide: Boolean = false) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.apply {
            isNavigationBarVisible = !hide
            setNavigationBarColor(color = Gunmetal)
        }
    }
}