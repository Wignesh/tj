package ga.veee.traveljournal.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ga.veee.traveljournal.R

val Poppins = FontFamily(
    Font(R.font.poppins, weight = FontWeight.Normal),
    Font(R.font.poppins_light,weight = FontWeight.Light),
    Font(R.font.poppins_medium,weight = FontWeight.Medium),
    Font(R.font.poppins_semibold,weight = FontWeight.SemiBold),
    Font(R.font.poppins_bold,weight = FontWeight.Bold),

    )

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)