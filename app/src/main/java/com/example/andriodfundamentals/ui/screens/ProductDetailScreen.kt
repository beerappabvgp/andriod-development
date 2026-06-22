package com.example.andriodfundamentals.ui.screens

import android.icu.text.CaseMap
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val BrandPurple = Color(0xFF4A148C)
private val AccentPurple = Color(0xFF7B1FA2)
private val LightLavender = Color(0xFFEDE7F6)
private val AccentGreen = Color(0xFF2E7D32)
private val SlateGray = Color(0xFF78909C)
private val FieldBorder = Color(0xFFCFD8DC)
private val PageBg = Color(0xFFF8F5FF)
private val CardWhite = Color(0xFFF8F5FF)
private val SelectedBlue = Color(0xFF1565C0)

@Composable
fun ProductDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg)
            .verticalScroll(rememberScrollState())
    ) {
        ProductImageBanner()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ProductTitleCard()
            SizeSelector()
            ColorSelector()
            ProductDetailsCard()
            BottomActionButtons()
        }

    }
}

@Composable
private fun ProductImageBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(BrandPurple, LightLavender)
                )
            )
    ) {
        SaleBadge(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
        RatingBadge(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )

//        emoji of shoe
        Text(
            text = "👟",
            fontSize = 100.sp,
            modifier = Modifier
                .align(Alignment.Center)
        )
//        text

        Text(
            text = "N I K E",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            color = Color.White.copy(alpha = 0.25f),
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 8.sp,
        )

    }
}

@Composable
private fun SaleBadge(modifier: Modifier = Modifier) {
    Text(
        text = "SALE",
        modifier = modifier
            .background(
                color = Color(0xFFD32F2F),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp),
        color = Color.White,
        fontSize =11.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 2.sp,
    )
}


@Composable
private fun RatingBadge(modifier: Modifier = Modifier) {
    Text(
        text = "4.8 ⭐",
        modifier = modifier
            .background(
                color = Color.Black.copy(alpha = 0.35f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp),
        color = Color.White,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ProductTitleCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "NIKE",
                    fontSize = 11.sp,
                    color = AccentPurple,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )

//                2nd item
                InStockBadge()
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Air Max 270"
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Men's Running Shoes"
            )

            Spacer(modifier = Modifier.height(14.dp))
            HorizontalDivider(color = FieldBorder)
            Spacer(modifier = Modifier.height(14.dp))

//            Row Layout

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "$12,999",
                    fontSize = 15.sp,
                    color = SlateGray,
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = "$8,999",
                    fontSize =26.sp,
                    color = AccentPurple,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "31% off",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AccentGreen,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE8F5E9),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "2.4k reviews • Free delivery above $999",
                fontSize = 12.sp,
                color = SlateGray
            )
        }
    }
}

@Composable
private fun InStockBadge() {
    Text(
        text = "● In Stock",
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = AccentGreen,
        modifier = Modifier
            .background(
                color = Color(0xFFE8F5E9),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}

@Composable
private fun SectionCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.5.sp,
                color = AccentPurple
            )

            Spacer(modifier = Modifier.height(4.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(14.dp))

            content()
        }
    }
}

@Composable
private fun SizeBox(
    label: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) SelectedBlue else CardWhite)
            .border(
                width = 1.5.dp,
                color = if (isSelected) SelectedBlue else FieldBorder,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color.White else SlateGray
        )
    }
}


@Composable
private fun SizeSelector() {
    SectionCard(title = "SELECT SIZE") {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SizeBox(label = "UK 7", isSelected = false, modifier = Modifier.weight(1f))
            SizeBox(label = "UK 8", isSelected = true, modifier = Modifier.weight(1f))
            SizeBox(label = "UK 9", isSelected = false, modifier = Modifier.weight(1f))
            SizeBox(label = "UK10", isSelected = false, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun ColorSelector() {
    SectionCard("SELECT COLOR") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ColorCircle("Black", isSelected = true, color = Color(0xFF1A1A1A))
            ColorCircle("Blue", isSelected = false, color = Color(0xFF35F5F5))
            ColorCircle("Red", isSelected = false, color = Color(0xFFD32F2F))
            ColorCircle("Navy", isSelected = false, color = Color(0xFF1565C0))
        }
    }
}

@Composable
private fun ColorCircle(
    label: String,
    color: Color,
    isSelected: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color)
                .then(
                    if (isSelected) {
                        Modifier.border(
                            width = 2.5.dp,
                            color = AccentPurple,
                            shape = CircleShape
                        )
                    } else {
                        Modifier
                    }
                )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = if (isSelected) AccentPurple else Color.Gray,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

@Composable
private fun ProductDetailsCard() {
    SectionCard("PRODUCT DETAILS") {
        SpecRow(label = "Material", value = "Preminum Mesh");
        SpecRow(label = "Weight", value = "280g")
        SpecRow(label = "Origin", value = "Vietnam")
        SpecRow(label = "Warranty", value = "1 Year")
        SpecRow(label = "SKU", value = "NK-AM270-BLK", isLast = true)
    }
}

@Composable
private fun SpecRow(
    label: String,
    value: String,
    isLast: Boolean = false
) {
    Row(
        modifier =
            Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = SlateGray
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1A1A2E)
        )
    }
    if(!isLast) {
        HorizontalDivider(color = FieldBorder)
    }
}

@Composable
private fun BottomActionButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            border = ButtonDefaults.outlinedButtonBorder,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = AccentPurple
            )
        ) {
            Text(
                text = "♡ Wishlist",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold

            )
        }

//        add to cart button
        Button(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AccentPurple,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = "Add to Cart",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}