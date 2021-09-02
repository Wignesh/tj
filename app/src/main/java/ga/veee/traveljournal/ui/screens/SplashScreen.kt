package ga.veee.traveljournal.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ga.veee.traveljournal.R
import ga.veee.traveljournal.navigation.Screens
import ga.veee.traveljournal.ui.theme.Gunmetal
import ga.veee.traveljournal.ui.theme.Gunmetal300
import ga.veee.traveljournal.ui.theme.Poppins
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Gunmetal)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
            )
            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )
            Text(
                text = "Travel Journal",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins,
                fontSize = 24.sp,
            )
        }
        LinearProgressIndicator(
            backgroundColor = Color.White,
            color = Gunmetal300,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .align(Alignment.BottomCenter)
        )

        LaunchedEffect(key1 = true) {
            delay(1500)
            navController.popBackStack()
            navController.navigate(Screens.OnBoard.route)
        }

    }
}
