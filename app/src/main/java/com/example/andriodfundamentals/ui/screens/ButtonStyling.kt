package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonStylingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement =Arrangement.Center
    ) {
        Text(
            text = "Button Styling",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

//        primary button

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1565C0),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Primary Button",
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

//        secondary button

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2E7D32),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Secondary Button",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            shape = RoundedCornerShape(90.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF9800),
                contentColor = Color.White,
            )
        ) {
            Text(
                text = "Rounded Button",
                fontSize = 16.sp
            )
        }

//        Disabled Buttons

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            enabled = false
        ) {
            Text(
                text = "Disabled Button",
                fontSize = 16.sp
            )
        }

    }
}