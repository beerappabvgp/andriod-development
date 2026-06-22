package com.example.andriodfundamentals.ui.screens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val HospitalNavy = Color(0xFF0D2B55)

private val HospitalBlue = Color(0xFF1565C0)

private val HospitalTeal = Color(0xFF0097A7)

private val SlateGray = Color(0xFF78909C)

private val FieldBorder = Color(0xFFCFD8DC)

private val PageBg = Color(0xFFF5F8FF)

private val CardWhite = Color(0xFFFFFFFF)


@Composable
fun HospitalRegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg)
            .verticalScroll(rememberScrollState())
    ) {
        HospitalHeader()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            PersonalInfoSection()
            ContactSection()
            AddressAndMedicalSection()
            RegisterButton()
            FooterLoginPrompt()
        }
    }
}

@Composable
private fun HospitalHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(HospitalNavy, HospitalTeal)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//              1st item - + ICON

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // space between 1st item and 2nd item
            Spacer(modifier = Modifier.height(12.dp))

//          2nd item

            Text(
                text = "City Care Hospital",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

//            3rd item
            Text(
                text = "Patient Registration",
                color = Color.White.copy(alpha = 0.80f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

        }
    }
}

@Composable
private fun SectionCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardWhite
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
//            1st item
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing =  1.5.sp,
                color = HospitalBlue
            )
            Spacer(modifier = Modifier.height(4.dp))
//            2nd item - line
            HorizontalDivider(color = FieldBorder)
            Spacer(modifier = Modifier.height(14.dp))
            content()
        }
    }
}

@Composable
private fun PatientTextField(
    label: String,
    placeholder: String
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        label = { Text(label) },
        placeholder = { Text(placeholder, color = SlateGray.copy(alpha = 0.6f))},
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = HospitalBlue,
            unfocusedBorderColor = FieldBorder,
            focusedLabelColor = HospitalBlue,
            unfocusedLabelColor = SlateGray,
            cursorColor = HospitalBlue
        )
    )
}

@Composable
private fun PersonalInfoSection() {
    SectionCard("PERSONAL INFORMATION", {
        PatientTextField("Patient Name", "Full name")
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
//            Item1 - Age  -  100 units 50 units for age and 50 units for blood group
//
            Box(modifier = Modifier.weight(1f)) {
                PatientTextField("Age", "Years")
            }
//            Item2 - Blood Group
            Box(modifier = Modifier.weight(1f)) {
                PatientTextField("Blood Group", "A+ B+...")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        PatientTextField("Gender", "Male / Female")

    })
}

@Composable
private fun ContactSection() {
    SectionCard("CONTACT DETAILS") {
        PatientTextField("Phone Number", "+91 7993873246")
        Spacer(modifier = Modifier.height(12.dp))
        PatientTextField("Email Address", "patient@gmail.com")
        Spacer(modifier = Modifier.height(12.dp))
        PatientTextField(label = "Emergency Contact", placeholder = "Gaurdian's phone number")
    }
}

@Composable
private fun AddressAndMedicalSection() {
    SectionCard("ADDRESS AND MEDICAL HISTROY") {
        PatientTextField("Address", placeholder = "Street, City, State, PIN")
        Spacer(modifier = Modifier.height(20.dp))
        PatientTextField("Medical History", placeholder = "Any previous illness " +
                "/ condition")
    }

}

@Composable
private fun RegisterButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = HospitalBlue,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = "Register Patient",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing =0.5.sp
        )
    }
}

@Composable
private fun FooterLoginPrompt() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Already Registered?",
            color = SlateGray,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Login",
            color = HospitalBlue,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}