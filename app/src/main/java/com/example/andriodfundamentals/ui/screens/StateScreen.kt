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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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



@Composable
fun LikeButtonScreen() {

    var isLiked by remember {
        mutableStateOf(false)
    }

    var likes by remember {
        mutableStateOf(0)
    }

    Column() {
        Text(
            text = "LIKE BUTTON"
        )

        Spacer(modifier = Modifier.height(40.dp))

        Card() {
            Column() {
                Row() {
                    Box() {
                        Text(
                            text = "B",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column() {
                        Text("Anil Kumar")
                        Text("2 hours ago")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Just completed andriod development training " +
                        "successfully")
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(color = Color(0xFFEEEEEE))
                Spacer(modifier = Modifier.height(16.dp))

                Row() {
                    Text(
                        text = "$likes likes"
                    )

                    Button(
                        onClick = {
                            isLiked = !isLiked
                            likes = if (isLiked) likes + 1 else likes - 1
                        }
                    ) {
                        Text(
                            text = if (isLiked) "❤️  Liked" else "🤍  Like")
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = ""
        )
    }
}


@Composable
fun LiveFormScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

//        state
        var name by remember { mutableStateOf("") }
        var role by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Text(
            text = "LIVE FROM PREVIEW",
            fontSize = 11.sp,
            letterSpacing = 3.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(containerColor = CardWhite)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Fill in your details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Blue
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = { Text("Full Name") },
                    placeholder = { Text("Type your name") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = formColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = role,
                    onValueChange = {
                        role = it
                    },
                    label = { Text("Job Role") },
                    placeholder = { Text("e.g Andriod developer") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = formColors()
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text("Email") },
                    placeholder = { Text("you@gmail.com") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = formColors()
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

//        Live preview
        Text(
            text = "LIVE PREVIEW"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.padding(20.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue
            )
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "A",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }

                Column() {
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Text(
                        text = role,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = email,
                        fontSize = 18.sp,
                        color = Color.White.copy(alpha = 0.60f)
                    )
                }
            }
        }
    }
}

@Composable
private fun formColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = Color.Blue,
    unfocusedBorderColor = Color(0xFFCFD8DC),
    focusedLabelColor = Color.Blue,
    unfocusedLabelColor = SlateGray,
    cursorColor = Color.Blue
)



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