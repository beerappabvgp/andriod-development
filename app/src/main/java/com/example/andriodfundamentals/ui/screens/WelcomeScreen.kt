package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen() {
    Column(modifier = Modifier.padding(all = 30.dp)) {
        Text(text = "Hello World !!!")
        Text(text = "Welcome to Andriod Development .... ")
        Text(text = "Andriod is a mobile operating system developed by google .... ")
        Text(text = "CS IS FUN !!!!")
        Text(text = "CS is all about solving real world customer facing and engineering problems ")
    }
}