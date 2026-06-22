package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.padding(30.dp)) {
        Text(
            text = "Student Profile "
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(text = "Name: ")
            Text(text = "Ganesha ... ")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(
                text = "Age: "
            )

            Text(
                text = "24"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

//        course related information

        Row {
            Text(
                text = "Course: "
            )
            Text(
                text = "Andriod Development .... "
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

//        college information

        Row {
            Text(
                text = "College : "
            )
            Text(
                text = "ABC Engineering college"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

//        city information

        Row {
            Text(
                text = "City : "
            )
            Text(
                text = "Hyderabad"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

//        Email

        Row {
            Text(
                text = "Email : "
            )
            Text(
                text = "beerappabharathb@gmail.com"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

//      About

        Text(
            text = "About"
        )

        Spacer(modifier = Modifier.height(10.dp));

        Text(
            text = "I am currently learning Andriod Development ...... using kotlin ... "
        )


    }
}