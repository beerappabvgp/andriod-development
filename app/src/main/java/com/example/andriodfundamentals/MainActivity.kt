package com.example.andriodfundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.andriodfundamentals.ui.screens.BusinessCardScreen
import com.example.andriodfundamentals.ui.screens.ButtonStylingScreen
import com.example.andriodfundamentals.ui.screens.EmployeeDashBoardScreen
import com.example.andriodfundamentals.ui.screens.HelpCenterScreen
import com.example.andriodfundamentals.ui.screens.LoginScreen
import com.example.andriodfundamentals.ui.screens.ProfileScreen
import com.example.andriodfundamentals.ui.screens.RestaurantInfoScreen
import com.example.andriodfundamentals.ui.screens.StudentRegistrationScreen
import com.example.andriodfundamentals.ui.screens.WelcomeScreen
import com.example.andriodfundamentals.ui.theme.AndriodFundamentalsTheme
import com.example.andriodfundamentals.ui.screens.HospitalRegistrationScreen
import com.example.andriodfundamentals.ui.screens.ProductDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndriodFundamentalsTheme {
//                WelcomeScreen()
//                  ProfileScreen()
//                RestaurantInfoScreen()
//                EmployeeDashBoardScreen()
//                HelpCenterScreen()
//                BusinessCardScreen()
//                StudentRegistrationScreen()
//                ButtonStylingScreen()
//                LoginScreen()
//                HospitalRegistrationScreen()
                ProductDetailScreen()
            }
        }
    }
}

