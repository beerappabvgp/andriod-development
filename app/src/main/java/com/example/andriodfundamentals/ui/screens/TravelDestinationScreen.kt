package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andriodfundamentals.R


private val TravelBlue   = Color(0xFF0D47A1)
private val TravelTeal   = Color(0xFF00897B)
private val AccentOrange = Color(0xFFE65100)
private val StarYellow   = Color(0xFFFDD835)
private val SlateGray    = Color(0xFF78909C)
private val FieldBorder  = Color(0xFFCFD8DC)
private val PageBg       = Color(0xFFF5F9FF)
private val CardWhite    = Color(0xFFFFFFFF)



// separate the data and the UI
data class Destination(
    val imageRes: Int,
    val badge: String,
    val badgeColor: Color,
    val title: String,
    val location: String,
    val rating: String,
    val reviewCount: String,
    val description: String,
    val highlights: List<String>,
    val price: String,
    val duration: String
)

private val destinationList = listOf<Destination>(
//    1st destination
    Destination(
        imageRes = R.drawable.banner_mountains,
        badge = "FEATURED",
        badgeColor = AccentOrange,
        title = "Swiss Alps",
        location = "Switzerland, Europe",
        rating = "4.9",
        reviewCount = "3.2k reviews",
        description = "Experience the breathtaking beauty of the Swiss Alps. " +
                "Snow-capped peaks, crystal-clear lakes, and charming " +
                "mountain villages await you at every turn.",
        highlights = listOf("❄️ Snow Activities" ,
            "🏨 Cozy Chalets", "🏔️ Hiking Trails",
            "🍫 Swiss Cuisine"),
        price = "1,85,000",
        duration = "7"
    ),

    Destination(
        imageRes = R.drawable.banner_beach,
        badge = "TRENDING",
        badgeColor = TravelTeal,
        title = "Maldives Beach",
        location = "Maldives, Indian Ocean",
        rating = "4.8",
        reviewCount = "5.1k reviews",
        description = "Escape to paradise with pristine white sand beaches, " +
                "turquoise lagoons, and world-class overwater bungalows " +
                "for an unforgettable tropical getaway.",
        highlights = listOf(
            "🤿 Snorkeling",
            "🌅 Sunsets",
            "🏝️ Private Islands",
            "🐠 Marine Life"
        ),
        price = "2,10,000",
        duration = "5"
    ),

    Destination(
        imageRes = R.drawable.banner_city,
        badge = "POPULAR",
        badgeColor = TravelBlue,
        title = "New York City",
        location = "New York, USA",
        rating = "4.7",
        reviewCount = "8.4k reviews",
        description = "The city that never sleeps — iconic skyline, world-famous " +
                "museums, Broadway shows, and diverse food culture packed " +
                "into one unforgettable destination.",
        highlights = listOf(
            "🗽 Landmarks",
            "🎭 Broadway",
            "🍕 Food Scene",
            "🛍️ Shopping",
        ),
        price = "1,60,000",
        duration = "6 days"
    )

)


@Composable
fun TravelDestinationScreen() {
    LazyColumn() {
        item {
            ScreenHeader()
        }

        items(destinationList) { destination ->
            DestinationCard(
                destination,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun DestinationCard(
    destination: Destination,
    modifier: Modifier = Modifier,
) {
    Column() {
        ImageBanner(
            imageRes = destination.imageRes,
            badge = destination.badge,
            badgeColor = destination.badgeColor
        )
    }
}

@Composable
fun ImageBanner(
    imageRes: Int,
    badge: String,
    badgeColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Travel destination photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

//        Overlay

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.10f),
                            Color.Black.copy(alpha = 0.50f)
                        )
                    )
                )
        )

//        Badge

        Text(
            text = badge,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(12.dp),
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.5.sp
        )
    }
}
@Composable
fun ScreenHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(TravelBlue, TravelBlue.copy(alpha = 0f))
                )
            )
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = "EXPLORE THE WORLD",
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 3.sp,
            color = Color.White.copy(alpha = 0.75f)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Top Destinations",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "3 handpicked places for you",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.70f)
        )
    }
}