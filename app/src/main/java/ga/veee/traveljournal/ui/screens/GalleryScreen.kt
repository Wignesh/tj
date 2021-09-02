package ga.veee.traveljournal.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ga.veee.traveljournal.R
import ga.veee.traveljournal.ui.theme.Gunmetal
import ga.veee.traveljournal.ui.theme.Poppins


@OptIn(ExperimentalAnimationApi::class)
@ExperimentalComposeUiApi
@Composable
fun GalleryScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp)
            .background(Color.White)
    ) {
        NavTopGallery(navController = navController)
        val scrollState = rememberScrollState()
        Column(Modifier.verticalScroll(state = scrollState)) {
            for (i in 1..1) {
                Column() {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.gal_1),
                            contentDescription = null,
                            Modifier
                                .width(168.dp)
                                .height(168.dp)
                                .aspectRatio(1.0F)
                                .clip(
                                    RoundedCornerShape(percent = 3)
                                )
                                .clickable { },
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.gal_2),
                            contentDescription = null,
                            Modifier
                                .width(168.dp)
                                .height(168.dp)
                                .aspectRatio(1.0F)
                                .clip(
                                    RoundedCornerShape(percent = 3)
                                )
                                .clickable { },
                            contentScale = ContentScale.Crop
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.gal_3),
                            contentDescription = null,
                            Modifier
                                .width(168.dp)
                                .height(168.dp)
                                .aspectRatio(1.0F)
                                .clip(
                                    RoundedCornerShape(percent = 3)
                                )
                                .clickable { },
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.gal_4),
                            contentDescription = null,
                            Modifier
                                .width(168.dp)
                                .height(168.dp)
                                .aspectRatio(1.0F)
                                .clip(
                                    RoundedCornerShape(percent = 3)
                                )
                                .clickable { },
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun NavTopGallery(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left_black),
            contentDescription = "Left",
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 36.dp,
                    bottom = 16.dp
                )
                .clickable {
                    navController.popBackStack()
                }
        )
        Text(
            text = "Photos",
            color = Gunmetal,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.width(24.dp))
    }
}