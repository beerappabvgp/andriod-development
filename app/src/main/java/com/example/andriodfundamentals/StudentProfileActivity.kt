package com.example.andriodfundamentals

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class StudentProfileActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedName = intent.getStringExtra(MainActivity.EXTRA_STUDENT_NAME)
            ?: "Unknown"
        val receivedCourse = intent.getStringExtra(MainActivity
            .EXTRA_STUDENT_COURSE) ?: "Unknown"

        setContent {
            MaterialTheme {
                StudentProfileScreen(studentName = receivedName, studentCourse = receivedCourse)
            }
        }
    }
}

@Composable
fun StudentProfileScreen(
    studentName: String,
    studentCourse: String
) {
    Column() {
        Text(
            text = "Student Profile"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Name: $studentName"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Course: $studentCourse"
        )
    }
}