package com.ryle.markethub.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.ryle.markethub.navigation.ROUT_ONBOARDING2

@Composable
fun Registerscreen(navController: NavController){

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(

            painter = painterResource(com.ryle.markethub.R.drawable.delivery),
            contentDescription = "this is a product",
            modifier = Modifier.height(200.dp).width(200.dp)


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


        //username
        OutlinedTextField(
            value = username,
            onValueChange = { username = it},
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
            label = { Text(text = "Username") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                unfocusedLabelColor = Color.Black,
                unfocusedLeadingIconColor = Color.Blue,
                focusedBorderColor = Color.Black


            )

        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            label = { Text(text = "email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                unfocusedLabelColor = Color.Black,
                unfocusedLeadingIconColor = Color.Blue,
                focusedBorderColor = Color.Black


            )

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            label = { Text(text = "password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                unfocusedLabelColor = Color.Black,
                unfocusedLeadingIconColor = Color.Blue,
                focusedBorderColor = Color.Black


            ),
            visualTransformation = PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmpassword,
            onValueChange = { confirmpassword = it},
            modifier = Modifier.width(350.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Done, contentDescription = "") },
            label = { Text(text = "confirmpassword") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                unfocusedLabelColor = Color.Black,
                unfocusedLeadingIconColor = Color.Blue,
                focusedBorderColor = Color.Black


            ),
            visualTransformation = PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = "Register")


        }

































    }

}

@Preview(showBackground = true)
@Composable
fun RegisterscreenPreview() {

    Registerscreen(rememberNavController())
}