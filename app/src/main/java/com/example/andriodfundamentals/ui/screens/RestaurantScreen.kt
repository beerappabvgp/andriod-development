package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantInfoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Sunrise Restaurant"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Cuisine: Indian"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Location: Hyderabad"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Rating : 4.7 / 5"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Open : 8:00 AM - 10:30 PM"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Popular dishes ... "
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Dosa .."
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Paneer ... "
        )


    }
}