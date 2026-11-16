package com.ryle.markethub.ui.screens.onboarding

import android.R
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.navigation.ROUT_ONBOARDING2

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
            contentDescription = "this is a product",
            modifier = Modifier.height(200.dp).width(200.dp)


        )

        Spacer(modifier = Modifier.height(20.dp))


        Text(

            text = "shop now.live better",
            color = Color.Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(20.dp))


        Text(

            text = "Powerful ecommerce platform that turn visitors into customers. Unified operations. Build a app, manage orders & payments, and market your brand with Zoho Commerce. ",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(10.dp))


        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = "Get started")


        }












    }
    
    










}

@Preview(showBackground = true)
@Composable
//to display Onboardingscreen1
fun Onboardingscreen1Preview() {

    Onboardingscreen1(rememberNavController())
}