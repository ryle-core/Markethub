package com.ryle.markethub.ui.screens.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//UI
fun Onboardingscreen3(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        TopAppBar(
            title = {   Text(text = "welcome")},

            navigationIcon = {

                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            },

            actions = {

                IconButton(onClick = {}) {

                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription ="a shopping cart" )


                }

                IconButton(onClick = {}) {

                    Icon(imageVector = Icons.Default.Share, contentDescription ="notification icon" )


                }




            },

            colors = TopAppBarDefaults.topAppBarColors(

                navigationIconContentColor = Color.Cyan,
                containerColor = Color.Blue,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White


            )





        )












    }


}

@Preview(showBackground = true)
@Composable
//to display Onboardingscreen3
fun Onboardingscreen3Preview() {

    Onboardingscreen3(rememberNavController())
}