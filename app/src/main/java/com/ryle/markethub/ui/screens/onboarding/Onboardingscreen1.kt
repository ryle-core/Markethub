package com.ryle.markethub.ui.screens.onboarding

import android.R
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
//UI
fun Onboardingscreen1(navController: NavController){
//styles passed inside the brackets in small letters....contents passed in the curlybraces in capital letters
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Image(

            painter = painterResource(com.ryle.markethub.R.drawable.products),
            contentDescription = "this is a product"
        )


        Text(

            text = "shop now.live better",
            color = Color.Blue
        )

        Text(

            text = "Powerful ecommerce platform that turn visitors into customers. Unified operations. Build a app, manage orders & payments, and market your brand with Zoho Commerce. "
        )









    }
    
    










}

@Preview(showBackground = true)
@Composable
//to display Onboardingscreen1
fun Onboardingscreen1Preview() {

    Onboardingscreen1(rememberNavController())
}