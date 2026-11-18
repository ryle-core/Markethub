package com.ryle.markethub.ui.screens.onboarding

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
import com.ryle.markethub.navigation.ROUT_HOME

@Composable
//UI
fun Onboardingscreen2(navController: NavController){

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

            text = "fast delivery",
            color = Color.Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )


        Text(

            text = "Need reliable parcel delivery in Kenya? markethub Delivery offers fast, affordable courier services for individuals & businesses. ",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate(ROUT_HOME)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = "Next")


        }















    }


}

@Preview(showBackground = true)
@Composable
//to display Onboardingscreen2
fun Onboardingscreen2Preview() {

    Onboardingscreen2(rememberNavController())
}