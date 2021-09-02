package ga.veee.traveljournal.model

data class Trip(
    val title: String,
    val date: String,
    val description: String,
    val isLiked: Boolean,
    val image: Int
)