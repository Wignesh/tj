package ga.veee.traveljournal


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import ga.veee.traveljournal.navigation.Navigation
import ga.veee.traveljournal.ui.theme.TravelJournalTheme
import ga.veee.traveljournal.utils.makeActivityFullScreen


@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeActivityFullScreen(window)
        setContent {
            ProvideWindowInsets(consumeWindowInsets = true, windowInsetsAnimationsEnabled = true) {
                TravelJournalTheme {
                    Surface(
                        color = MaterialTheme
                            .colors.background,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Navigation()
                    }
                }
            }

        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {

    }
}
