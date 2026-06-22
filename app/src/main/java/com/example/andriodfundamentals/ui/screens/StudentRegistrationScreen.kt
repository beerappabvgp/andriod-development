package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentRegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Student Registration",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFA1565C0)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Please fill all your details ....",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = {
                Text("Full Name")
            },
            placeholder = {
                Text("Enter your full name")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = {
                Text("Phone Number")
            },
            placeholder = {
                Text("Enter your contact number")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = {
                Text("College")
            },
            placeholder = {
                Text("Enter your college name")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = {
                Text("Course")
            },
            placeholder = {
                Text("Enter your course")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = {
                Text("City")
            },
            placeholder = {
                Text("Enter your city")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

//        button to submit the form

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text(
                text = "Submit Registration",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}