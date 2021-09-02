package ga.veee.traveljournal.repo

import ga.veee.traveljournal.R
import ga.veee.traveljournal.model.Trip


val RepoStore = listOf<Trip>(

    Trip(
        "Trip to Maldives",
        "Feb 21,2020",
        "Maldives, officially the Republic of Maldives, is a small archipelagic state in the Indian subcontinent of Asia, situated in the Indian Ocean. ",
        false,
        R.drawable.maldives
    ),
    Trip(
        "Trip to Netherlands",
        "Jan 21,2020",
        "The Netherlands, a country in northwestern Europe, is known for a flat landscape of canals, tulip fields, windmills and cycling routes. Amsterdam, the capital, is home to the Rijksmuseum, Van Gogh Museum and the house where Jewish diarist Anne Frank hid during WWII",
        true,
        R.drawable.netharland
    ),
    Trip(
        "Trip to Tokyo",
        "March 21,2019",
        "Tokyo comes to life at night. The best places to experience nightlife in Tokyo are Shinjuku, Shibuya, Ginza, Roppongi and Tokyo Tower. In Tokyo...",
        false,
        R.drawable.tokyo
    ),

    )