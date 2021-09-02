package ga.veee.traveljournal.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ga.veee.traveljournal.R
import ga.veee.traveljournal.model.Trip
import ga.veee.traveljournal.repo.RepoStore
import ga.veee.traveljournal.ui.theme.Gunmetal
import ga.veee.traveljournal.ui.theme.Poppins
import kotlin.math.round


@OptIn(ExperimentalAnimationApi::class)
@ExperimentalComposeUiApi
@Composable
fun ArchivedScreen(navController: NavController) {

    Column(
        Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp)
                .background(Color.White)
        ) {
            NavTopArchived(navController = navController)

        }
        Spacer(modifier = Modifier.height(12.dp))
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            val constraints = constraints
            val scrollState = rememberScrollState()
            Column(Modifier.verticalScroll(scrollState)) {
                for (trip in RepoStore) {
                    ArchivedCard(constraints, trip)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

    }
}


@Composable
fun NavTopArchived(navController: NavController) {

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
            text = "Archived",
            color = Gunmetal,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.width(24.dp))
    }
}

@Composable
fun ArchivedCard(parentConstraints: Constraints, trip: Trip) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(percent = 4))
            .fillMaxWidth()
            .height(round(parentConstraints.maxHeight / 6F).dp)

    ) {
        Image(
            painter = painterResource(id = trip.image),
            contentDescription = "Card BG",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(percent = 4))
                .fillMaxSize()
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
        var isLiked by remember { mutableStateOf(trip.isLiked) }

        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable {
                    isLiked = !isLiked
                }
        ) {
            Crossfade(targetState = isLiked) { scene ->
                when (scene) {
                    true -> Image(
                        painter = painterResource(id = R.drawable.like_filled),
                        contentDescription = "Like Button",
                        modifier = Modifier
                            .padding(
                                end = 24.dp,
                                top = 16.dp,
                                start = 16.dp,
                                bottom = 16.dp
                            )
                    )
                    false -> Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like Button",
                        modifier = Modifier
                            .padding(
                                end = 24.dp,
                                top = 16.dp,
                                start = 16.dp,
                                bottom = 16.dp
                            )
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .align(Alignment.BottomStart),
        ) {
            Text(
                text = trip.title,
                color = Color.White,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = trip.date,
                color = Color.LightGray,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        }
    }
}