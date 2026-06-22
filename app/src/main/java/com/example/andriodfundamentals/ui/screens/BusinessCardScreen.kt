package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "NextGenInnovations",
            fontSize = 30.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            letterSpacing = 3.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Ganesha",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Android Developer",
            fontSize = 20.sp,
            color = Color.DarkGray,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "About",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Passionate about building andriod applications using kotlin ... .",
            lineHeight = 24.sp,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "+91 7993873246",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Office",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Hyderabad",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Employee Bio",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Worked as Software Engineer , Solved core CS problems during the journey ....",
            overflow = TextOverflow.Ellipsis
        )

    }
}