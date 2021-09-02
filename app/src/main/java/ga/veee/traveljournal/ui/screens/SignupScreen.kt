package ga.veee.traveljournal.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
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
import ga.veee.traveljournal.ui.theme.*

@ExperimentalAnimationApi
@Composable
fun SignupScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val insets = LocalWindowInsets.current
    val imeBottom = with(LocalDensity.current) { insets.ime.bottom.toDp() }
    Column(
        modifier = Modifier
            .background(GunF7)
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = imeBottom)
    ) {
        Image(
            painter = painterResource(id = R.drawable.tent),
            contentDescription = "Tent",
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .padding(top = 40.dp)
                .align(Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .shadow(
                    elevation = 3.dp,
                    clip = true,
                    shape = RoundedCornerShape(topStartPercent = 5, topEndPercent = 5)
                )
                .padding(all = 30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Sign-Up",
                color = Gunmetal,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                fontSize = 22.sp
            )
            AnimatedVisibility(visible = false) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(shape = CircleShape)
                        .background(color = GunFF)
                        .align(Alignment.CenterHorizontally)
                        .clickable(
                            enabled = true,
                            onClick = {

                            },
                            onClickLabel = "Profile",
                            role = Role.Image,
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "Camera",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }
            Column(Modifier.padding(horizontal = 1.dp)) {
                Text(
                    text = "Name",
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
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
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
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
            Column(Modifier.padding(horizontal = 1.dp)) {
                Text(
                    text = "Confirm Password",
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
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
                        text = "Signup",
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
                    text = "Already have an account ?",
                    fontSize = 14.sp,
                    color = Gunnery,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(
                    onClick = {
                        navController.popBackStack(Screens.Login.route, inclusive = false)
                    }
                ) {
                    Text(
                        text = "Login",
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