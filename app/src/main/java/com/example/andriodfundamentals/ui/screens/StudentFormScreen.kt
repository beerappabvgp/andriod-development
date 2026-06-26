package com.example.andriodfundamentals.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StudentFormScreen(
    onSubmittedClicked: (studentName: String, studentCourse: String) -> Unit
) {
    var studentName by remember {
        mutableStateOf("")
    }
    var studentCourse by remember {
        mutableStateOf("")
    }
    Column() {
        Text(
            text = "Enter student details"
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = studentName,
            onValueChange = {
                studentName = it
            },
            label = {
                Text("Student Name")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = studentCourse,
            onValueChange = {
                studentCourse = it
            },
            label = { Text("Course")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onSubmittedClicked(studentName, studentCourse)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View student profile")
        }
    }
}