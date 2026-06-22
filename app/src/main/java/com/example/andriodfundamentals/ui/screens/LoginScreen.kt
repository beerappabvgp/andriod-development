package com.example.andriodfundamentals.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val DeepBlue = Color(0xFF1A237E)

private val MidBlue = Color(0xFF1565C0)

private val SkyAccent = Color(0xFF42A5F5)

private val SlateGray = Color(0xFF78909C)

private val PageBg = Color(0xFFF0F4FF)

private val SurfaceWhite = Color(0xFFFFFFFF)

private val FieldBorder = Color(0xFFCFD8DC)


@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg)
    ) {
        TopGradientBand()
        Column(
            modifier =Modifier.fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginHeading()
            Spacer(modifier = Modifier.height(28.dp))
            LoginFormCard()
            Spacer(modifier = Modifier.height(28.dp))
            LoginButton()
            Spacer(modifier = Modifier.height(32.dp))
            SignUpPrompt()
        }
    }
}

@Composable
private fun LoginHeading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.linearGradient(listOf(DeepBlue, SkyAccent))
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Welcome Back",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = DeepBlue,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            style = MaterialTheme.typography.bodyLarge,
            color = SlateGray,
            text = "Sign in to continue",
            textAlign = TextAlign.Center
        )


    }
}

@Composable
fun TopGradientBand() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(DeepBlue, SkyAccent.copy(alpha = 0f))
                )
            )
    ) {

    }
}

@Composable
private fun LoginFormCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceWhite)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            EmailField()
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField()
            Spacer(modifier = Modifier.height(16.dp))
            ForgetPasswordLink()
        }
    }
}

//Email field
@Composable
private fun EmailField() {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange =  {},
        label = { Text("Email Address") },
        placeholder ={ Text("Enter Your Email ")},
        supportingText = { Text("Example: ganesha@email.com ")},
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        colors = LoginFieldColors()
    )
}

//Password field
@Composable
private fun PasswordField() {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        label = { Text("Password") },
        placeholder = { Text("Enter your password ")},
        supportingText ={ Text("Minimum 8 characters")},
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        colors = LoginFieldColors()
    )
}

@Composable
private fun ForgetPasswordLink() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Forgot Password?",
        textAlign = TextAlign.End,
        color = MidBlue,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.SemiBold,
    )
}

@Composable
private fun LoginButton() {
    Button (
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MidBlue,
            contentColor = Color.White,
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp,
        )
    }
}

// Sign up prompt
@Composable
private fun SignUpPrompt() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Don't have an account?",
            color = SlateGray,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Create New Account",
            color = MidBlue,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun LoginFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = MidBlue,
    unfocusedBorderColor = FieldBorder,
    focusedLabelColor = MidBlue,
    unfocusedLabelColor = SlateGray,
    cursorColor = MidBlue
)