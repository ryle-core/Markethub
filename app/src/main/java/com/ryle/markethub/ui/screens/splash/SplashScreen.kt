package com.ryle.markethub.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.navigation.ROUT_HOME
import com.ryle.markethub.navigation.ROUT_ONBOARDING1
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    //Navigation
    val x = rememberCoroutineScope()
    x.launch {

        delay(2000)

        navController.navigate(ROUT_ONBOARDING1)

        



    }




    Column(
        modifier = Modifier.fillMaxSize().background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



        Image(

            painter = painterResource(com.ryle.markethub.R.drawable.delivery),
            contentDescription = "this is a product",
            modifier = Modifier.height(200.dp).width(200.dp)


        )






    }

}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {

    SplashScreen(rememberNavController())
}