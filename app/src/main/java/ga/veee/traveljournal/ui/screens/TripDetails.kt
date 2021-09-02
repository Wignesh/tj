package ga.veee.traveljournal.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import ga.veee.traveljournal.model.Trip
import ga.veee.traveljournal.repo.RepoStore
import ga.veee.traveljournal.ui.theme.Gunmetal300
import ga.veee.traveljournal.ui.theme.Poppins

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun TripDetailsScreen(navController: NavController, tripId: Int) {
    val scrollState = rememberScrollState()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val trip = RepoStore[tripId]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = trip.image),
                contentDescription = "Card BG",
                modifier = Modifier
                    .fillMaxWidth()
                    .height((constraints.maxHeight / 6).dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )
            TopNavTrip(navController, trip)
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
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .verticalScroll(state = scrollState)

        ) {
//            BottomSheetScaffold(
//                scaffoldState = bottomSheetScaffoldState,
//                modifier = Modifier.fillMaxWidth().height(500.dp),
//                sheetContent = {
////                    JournalDetailSheet()
//                }, sheetPeekHeight = 0.dp
//            ) {
//                JournalDescription()
//            }
            JournalDescription(trip)

            TripPhotos()
            EditJournalButton()
        }
    }
}

@Composable
fun JournalDescription(trip: Trip) {
    Spacer(Modifier.height(20.dp))
    Column(
        Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(percent = 10)
            )
            .clip(RoundedCornerShape(percent = 10))
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Journal",
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                fontSize = 18.sp
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_up),
                    contentDescription = null,
                    Modifier
                        .width(16.dp)
                        .height(16.dp)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = "Swipe up to Read",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Gunmetal300
                )
            }


        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = trip.description,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun EditJournalButton() {
    Spacer(Modifier.height(16.dp))
    Button(
        onClick = {
        },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Edit Journal",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "Arrow"
            )
        }
    }
}

@Composable
fun TripPhotos() {
    Spacer(Modifier.height(16.dp))
    Column(
        Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(percent = 10)
            )
            .clip(RoundedCornerShape(percent = 10))
            .background(color = Color.White)
            .padding(12.dp, vertical = 16.dp),
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gallery_black),
                    contentDescription = null,
                    Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "Photos",
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    fontSize = 18.sp
                )
            }
            Image(
                painter = painterResource(id = R.drawable.add),
                contentDescription = null,
                Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clip(shape = RoundedCornerShape(percent = 100))
                    .clickable { }
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.gal_1),
                contentDescription = null,
                Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .aspectRatio(1.0F)
                    .clip(
                        RoundedCornerShape(percent = 10)
                    )
                    .clickable { },
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.gal_2),
                contentDescription = null,
                Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .aspectRatio(1.0F)
                    .clip(
                        RoundedCornerShape(percent = 10)
                    )
                    .clickable { },
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.gal_3),
                contentDescription = null,
                Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .aspectRatio(1.0F)
                    .clip(
                        RoundedCornerShape(percent = 10)
                    )
                    .clickable { },
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.gal_4),
                contentDescription = null,
                Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .aspectRatio(1.0F)
                    .clip(
                        RoundedCornerShape(percent = 10)
                    )
                    .clickable { },
                contentScale = ContentScale.FillBounds
            )
        }
    }

}

@Composable
fun TopNavTrip(navController: NavController, trip: Trip) {
    Column(
        modifier = Modifier
            .padding(top = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "Left",
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                    .clickable {
                        navController.popBackStack()
                    }
            )
            var isLiked by remember { mutableStateOf(trip.isLiked) }
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
                            .clickable {
                                isLiked = !isLiked
                            }
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
                            .clickable {
                                isLiked = !isLiked
                            }
                    )
                }
            }
        }
    }
}