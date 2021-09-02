package ga.veee.traveljournal.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import ga.veee.traveljournal.ui.screens.*
import kotlin.math.roundToInt


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(
            route = Screens.Splash.route,
            exitTransition = { _, _ ->
                slideOutVertically(
                    targetOffsetY = { fullHeight -> (-fullHeight) },
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screens.OnBoard.route,
            enterTransition = { _, _ ->
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.10f)
                    )
                )
            },
            exitTransition = { _, _ ->
                slideOutVertically(
                    targetOffsetY = { fullHeight -> (-fullHeight / 1.6).roundToInt() },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            popEnterTransition = { _, _ ->
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )

            },
        ) {
            OnBoardScreen(navController = navController)
        }
        composable(
            route = Screens.Login.route,
            popEnterTransition = { _, _ ->
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            enterTransition = { _, _ ->
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, _ ->
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screens.Signup.route,
            enterTransition = { _, _ ->
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, _ ->
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) {
            SignupScreen(navController = navController)
        }

        composable(
            route = Screens.Home.route,
            popEnterTransition = { initial, _ ->

                when (initial.destination.route) {
                    Screens.TripDetails.route -> fadeIn(
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                        )
                    )
                    Screens.NewJournal.route -> fadeIn(
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                        )
                    )
                    else -> fadeIn(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                        )
                    )
                }

            },
            enterTransition = { _, _ ->
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    Screens.TripDetails.route -> fadeOut(
                        animationSpec = tween(
                            durationMillis = 400,
                            easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                        )
                    )
                    Screens.NewJournal.route -> fadeOut(
                        animationSpec = tween(
                            durationMillis = 400,
                            easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                        )
                    )
                    else -> fadeOut(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                        )
                    )
                }
            },
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screens.Archived.route,
            enterTransition = { _, _ ->
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, _ ->
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) {
            ArchivedScreen(navController = navController)
        }
        composable(
            route = Screens.Gallery.route,
            enterTransition = { _, _ ->
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, _ ->
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) {
            GalleryScreen(navController = navController)
        }
        composable(
            route = "${Screens.TripDetails.route}/{tripId}",
            arguments = listOf(navArgument("tripId") { type = NavType.IntType }),
            enterTransition = { _, _ ->
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, _ ->
                slideOutVertically(
                    targetOffsetY = { fullHeight -> (fullHeight / 1.0).roundToInt() },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) { backStackEntry ->
            TripDetailsScreen(
                navController = navController,
                backStackEntry.arguments!!.getInt("tripId", 1)
            )
        }
        composable(
            route = Screens.NewJournal.route,
            enterTransition = { _, _ ->
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
            exitTransition = { _, _ ->
                slideOutVertically(
                    targetOffsetY = { fullHeight -> (fullHeight / 1.0).roundToInt() },
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = CubicBezierEasing(0.08f, 0.93f, 0.68f, 1.00f)
                    )
                )
            },
        ) {
            NewJournalScreen(navController = navController)
        }
    }
}