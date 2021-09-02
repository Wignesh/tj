package ga.veee.traveljournal.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import ga.veee.traveljournal.R
import ga.veee.traveljournal.navigation.Screens
import ga.veee.traveljournal.model.Trip
import ga.veee.traveljournal.repo.RepoStore
import ga.veee.traveljournal.ui.theme.Gunmetal
import ga.veee.traveljournal.ui.theme.Poppins
import kotlinx.coroutines.CoroutineScope
import kotlin.math.absoluteValue
import kotlin.math.round

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(navController: NavController) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        modifier = Modifier.fillMaxSize(),
        sheetContent = {
            JournalDetailSheet()
        }, sheetPeekHeight = 0.dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFFCFCFC))
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_top_bg),
                    contentDescription = "Bg",
                    modifier = Modifier
                        .width((round(constraints.maxWidth / 4.0).dp))
                        .align(Alignment.TopStart),
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(id = R.drawable.home_bottom_bg),
                    contentDescription = "Bg",
                    modifier = Modifier
                        .width((round(constraints.maxWidth / 4.0).dp))
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Fit
                )

                Box(Modifier.align(alignment = Alignment.BottomCenter)) {
                    BottomNavHome(navController)
                }

                Column(Modifier.fillMaxWidth()) {
                    TopNavHome(navController)
                    MyJournals(
                        coroutineScope = coroutineScope,
                        bottomSheetScaffoldState = bottomSheetScaffoldState,
                        navController = navController
                    )
                }
            }
        }
    }

}

@Composable
fun TripCard(parentConstraints: Constraints,trip:Trip) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(percent = 10))
            .width(parentConstraints.maxWidth.dp / 4)
            .height(round(parentConstraints.maxHeight / 3.5F).dp)

    ) {
        Image(
            painter = painterResource(id = trip.image),
            contentDescription = "Card BG",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(percent = 10))
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

@Composable
fun TopNavHome(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.user),
            contentScale = ContentScale.FillWidth,
            contentDescription = "User",
            modifier = Modifier
                .size(64.dp)
                .clip(shape = RoundedCornerShape(percent = 30))
                .clickable {
                }

        )
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(percent = 30))
            .background(color = Color(0XEEEEEEEE))
            .clickable {
            }
            .size(64.dp)) {
            Image(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Settings",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun BottomNavHome(navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 16.dp,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
            .clip(RoundedCornerShape(percent = 20))
            .border(
                width = 2.dp,
                color = Color(0XFFF9F9F9),
                shape = RoundedCornerShape(percent = 20)
            )
            .background(color = Color.White)
            .shadow(elevation = 16.dp)
            .height(64.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.archive),
                contentDescription = "Archive",
                modifier = Modifier
                    .size(24.dp)
                    .aspectRatio(1.0F)
                    .clickable {
                        navController.navigate(Screens.Archived.route)
                    }

            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .size(56.dp)
                    .clip(shape = RoundedCornerShape(percent = 100))
                    .background(Gunmetal)
                    .aspectRatio(1.0F)
                    .clickable {
                        navController.navigate(Screens.NewJournal.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Plus",
                    modifier = Modifier
                        .size(28.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.gallery),
                contentDescription = "Gallery",
                modifier = Modifier
                    .size(24.dp)
                    .aspectRatio(1.0F)
                    .clickable {
                        navController.navigate(Screens.Gallery.route)
                    }
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun MyJournals(
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    navController: NavController
) {
    Text(
        text = "Your \n" +
                "Journals",
        color = Gunmetal,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 34.sp,
        modifier = Modifier
            .padding(horizontal = 18.dp)
    )

    val pagerState =
        rememberPagerState(
            pageCount = RepoStore.size,
            initialOffscreenLimit = 1,
            initialPage = 1
        )

    AnimatedVisibility(visible = true) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            itemSpacing = 0.dp
        ) { page ->
            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
            BoxWithConstraints(
                Modifier
                    .offset {
                        IntOffset(
                            x = 0, y = (32.dp * pageOffset).roundToPx(),
                        )
                    }
                    .clip(shape = RoundedCornerShape(percent = 10))
                    .clickable {
                        navController.navigate("${Screens.TripDetails.route}/${page}")
//                        coroutineScope.launch {
//                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
//                                bottomSheetScaffoldState.bottomSheetState.expand()
//                            } else {
//                                bottomSheetScaffoldState.bottomSheetState.collapse()
//                            }
//                        }
                    }
            ) {
                TripCard(constraints, RepoStore[page])
            }
        }

    }
}

@Composable
fun JournalDetailSheet() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.card_image),
                contentDescription = "Card BG",
                modifier = Modifier
                    .fillMaxWidth()
                    .height((constraints.maxHeight / 5).dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 24.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
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
                            .clickable { }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like Button",
                        modifier = Modifier
                            .padding(
                                end = 24.dp,
                                top = 16.dp,
                                start = 16.dp,
                                bottom = 16.dp
                            )
                            .clickable { }
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .align(Alignment.BottomStart),
            ) {
                Text(
                    text = "Trip to Tokyo",
                    color = Color.White,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "March 21, 2019",
                    color = Color.LightGray,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}