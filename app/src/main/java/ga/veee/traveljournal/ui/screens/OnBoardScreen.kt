package ga.veee.traveljournal.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import ga.veee.traveljournal.ui.theme.Gunnery
import ga.veee.traveljournal.ui.theme.Poppins

@Composable
fun OnBoardScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(Color.White)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ob_bg),
                contentDescription = "OB BG",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            )
            Image(
                painter = painterResource(id = R.drawable.hero),
                contentDescription = "Hero",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "OB BG",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 40.dp, start = 32.dp)
                    .width(80.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .background(Color.White)
        ) {
            Text(
                text = "Travel Journal",
                fontSize = 18.sp,
                color = Gunnery,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "Mysterious treasures in the Netherlands",
                fontSize = 24.sp,
                color = Gunmetal,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    navController.navigate(Screens.Login.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Get Started",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = "Arrow"
                    )
                }
            }
        }


    }
}
