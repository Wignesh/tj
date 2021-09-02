package ga.veee.traveljournal.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.insets.LocalWindowInsets
import ga.veee.traveljournal.R
import ga.veee.traveljournal.navigation.Screens
import ga.veee.traveljournal.ui.theme.GunF7
import ga.veee.traveljournal.ui.theme.Gunmetal
import ga.veee.traveljournal.ui.theme.Gunnery
import ga.veee.traveljournal.ui.theme.Poppins

@ExperimentalAnimationApi
@Composable
fun LoginScreen(navController: NavController) {
    val insets = LocalWindowInsets.current
    val imeBottom = with(LocalDensity.current) { insets.ime.bottom.toDp() }
    Box(
        modifier = Modifier
            .background(GunF7)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.plane),
            contentDescription = "Plane",
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .padding(top = 40.dp)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    clip = true,
                    shape = RoundedCornerShape(topStartPercent = 5, topEndPercent = 5)
                )
                .background(color = Color.White)
                .padding(all = 30.dp)
                .padding(bottom = imeBottom)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Log-In",
                color = Gunmetal,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            Column(Modifier.padding(horizontal = 1.dp)) {
                Text(
                    text = "Email",
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    isError = false,
                    enabled = true,
                    textStyle = TextStyle(fontFamily = Poppins,fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Gunmetal),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(Modifier.padding(horizontal = 1.dp)) {
                Text(
                    text = "Password",
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    isError = false,
                    enabled = true,
                    textStyle = TextStyle(fontFamily = Poppins,fontWeight = FontWeight.Medium, fontSize = 18.sp, color = Gunmetal),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screens.Home.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Login",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                    )
                    AnimatedVisibility(visible = false) {
                        Spacer(modifier = Modifier.width(8.dp))
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier
                                .height(18.dp)
                                .width(18.dp),
                            strokeWidth = 2.dp,
                            progress = 0.0F
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Don't have an account ?",
                    fontSize = 14.sp,
                    color = Gunnery,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(
                    onClick = {
                        navController.navigate(Screens.Signup.route)
                    }
                ) {
                    Text(
                        text = "Signup",
                        fontSize = 14.sp,
                        color = Gunmetal,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}