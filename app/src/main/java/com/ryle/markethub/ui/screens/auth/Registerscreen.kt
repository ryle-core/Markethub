
package com.ryle.markethub.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.R
import com.ryle.markethub.navigation.ROUT_LOGIN

@Composable
fun Registerscreen(

    onRegister: (String, String, String, String) -> Unit, navController: NavController
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Product image",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Join us and start your journey",
            color = Color.Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Username")
            },
            label = { Text("Username") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = confirmpassword,
            onValueChange = {
                confirmpassword = it
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Done, contentDescription = "Confirm password")
            },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                errorMessage = when {
                    username.isBlank() ->
                        "Please enter your username"

                    email.isBlank() ||
                            !android.util.Patterns.EMAIL_ADDRESS
                                .matcher(email.trim()).matches() ->
                        "Please enter a valid email address"

                    password.isBlank() ->
                        "Please enter your password"

                    confirmpassword.isBlank() ->
                        "Please confirm your password"

                    password != confirmpassword ->
                        "Passwords do not match"

                    else -> ""
                }

                if (errorMessage.isEmpty()) {
                    onRegister(
                        username.trim(),
                        email.trim(),
                        password,
                        confirmpassword
                    )
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp)
        ) {
            Text("Register")

        }

       TextButton(
           onClick = { navController.navigate(ROUT_LOGIN)}

       ) {Text(text = "Already have an account?Login") }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterscreenPreview() {
    Registerscreen(
        onRegister = { _, _, _, _ -> },rememberNavController()
    )
}
