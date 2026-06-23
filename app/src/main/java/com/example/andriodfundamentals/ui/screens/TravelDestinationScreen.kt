package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextAlign
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
        duration = "7 days"
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
        duration = "5 days"
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
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg),
        contentPadding = PaddingValues(bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
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
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ImageBanner(
            imageRes = destination.imageRes,
            badge = destination.badge,
            badgeColor = destination.badgeColor
        )
        TitleSection(
            title = destination.title,
            location = destination.location,
            rating = destination.rating,
            reviewCount = destination.reviewCount
        )
        AboutSection(description = destination.description);
        HighLightsSection(highlights = destination.highlights);
        BookingRow(price = destination.price, duration = destination.duration)
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
                .padding(12.dp)
                .background(color = badgeColor, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 11.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.5.sp,
            color = Color.White,
        )

//        Explore chip
        Text(
            text = "📍 Tap to explore",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .background(
                    color = Color.Black.copy(alpha = 0.38f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 10.dp, vertical = 6.dp),
            color = Color.White,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun TitleSection(
    title: String,
    location: String,
    rating: String,
    reviewCount: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
//            item1
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1A1A2E)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "📍 $location",
                    fontSize = 13.sp,
                    color = SlateGray
                )
            }

//            item 2
            Column() {
                Text(
                    text = "⭐ $rating",
                    fontSize =16.sp,
                    fontWeight = FontWeight.Bold,
                    color = StarYellow
                )
                Text(
                    text = reviewCount,
                    fontSize = 11.sp,
                    color = SlateGray
                )
            }
        }
    }
}


@Composable
private fun AboutSection(
    description: String
) {
    SectionCard(title = "ABOUT THIS PLACE") {
        Text(
            text = description,
            fontSize = 14.sp,
            color = Color(0xFF424242),
            lineHeight = 22.sp
        )
    }
}

@Composable
private fun SectionCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.5.sp,
                color = TravelBlue
            )
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalDivider(color = FieldBorder)
            Spacer(modifier = Modifier.height(12.dp))
            content()
        }
    }
}

@Composable
private fun BookingRow(price: String, duration: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Starting from",
                fontSize = 11.sp,
                color = SlateGray
            )
            Text(
                text = price,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TravelBlue
            )
            Text(text = "per person . $duration",
                fontSize = 11.sp,
                color = SlateGray
            )
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = TravelBlue,
                contentColor = Color.White
            ),
            modifier = Modifier.height(50.dp)
        ) {
            Text(
                text = "Book Now",
                fontWeight = FontWeight.Bold,
                fontSize =14.sp,
            )
        }

//        Whislist
        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = TravelBlue
            ),
            modifier = Modifier.height(50.dp)
        ) {
            Text(
                text = "♡",
                fontWeight = FontWeight.Bold,
                fontSize =18.sp
            )
        }
    }
}

@Composable
private fun HighLightsSection(highlights: List<String>) {
    SectionCard(title = "HIGHLIGHTS") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            highlights.take(2).forEach { item ->
                HighLightChip(text = item, modifier = Modifier.weight(1f))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            highlights.drop(2).take(2).forEach { item ->
                HighLightChip(text = item, modifier = Modifier.weight(1f))
            }
        }
    }
}


@Composable
private fun HighLightChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = Color(0xFFE3F2FD), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = TravelBlue,
            textAlign = TextAlign.Center
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