package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val PageBg = Color(0xFFF5F7FF)
private val SlateGray = Color(0xFF78909C)

private val CardWhite = Color(0xFFFFFFFF)
@Composable
fun CounterScreen() {
//    state

    var count by remember {
        mutableStateOf(0)
    }


    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(PageBg),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "COUNTER",
            fontSize = 11.sp,
            letterSpacing = 3.sp,
            fontWeight = FontWeight.ExtraBold,
            color = SlateGray
        )
        Spacer(modifier = Modifier.height(40.dp))

//        diaplay the number on the screen

        Card(
            modifier = Modifier.size(160.dp),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = CardWhite)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$count",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (count > 0) Color.Blue
                    else if (count < 0) Color(0xFFD32F2F)
                    else SlateGray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = when {
                count > 0 -> "Positive"
                count < 0 -> "Negative"
                else -> "Zero"
            },
            fontSize = 14.sp,
            color = SlateGray
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                onClick = {
                    count--
                },
                modifier = Modifier.size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD32F2F),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "-",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

//                RESET button
        OutlinedButton(
            onClick = {
                count = 0
            },
            modifier = Modifier.size(64.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = "R", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }


//                PLus Button
        Button(
            onClick = {
                count++
            },
            modifier = Modifier.size(64.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text("+", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        }

//        Live feedback
        Text(
            text = "You tapped ${Math.abs(count)} times",
            fontSize = 13.sp,
            color = SlateGray
        )
    }
}



// state - count
// data on the screen
// UI



//fun CounterScreen() {
//    var count  = 0;
//    count = count + 1
//    return count
//}

// CounterScreen() => count = 1
// CounterScreen() => count = 1