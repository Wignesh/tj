package ga.veee.traveljournal.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object OnBoard : Screens("onboard_screen")
    object Login : Screens("login_screen")
    object Signup : Screens("signup_screen")
    object Home : Screens("home_screen")
    object Archived : Screens("archived_screen")
    object Gallery : Screens("gallery_screen")
    object TripDetails : Screens("trip_details_screen")
    object NewJournal : Screens("new_journal_screen")
}
