package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmployeeDashBoardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Employee DashBoard"
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Department: Information Technology"
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text ="Employee ID: EMP2026"
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Experience: 3 Years"
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Location: Hyderabad"
        )

    }
}