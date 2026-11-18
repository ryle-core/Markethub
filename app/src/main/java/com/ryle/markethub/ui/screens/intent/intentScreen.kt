package com.ryle.markethub.ui.screens.intent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.navigation.ROUT_ONBOARDING2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun intentscreen(navController: NavController){


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {   Text(text = "Home")},

            navigationIcon = {

                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            },

            actions = {

                IconButton(onClick = {}) {

                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="a shopping cart" )


                }

                IconButton(onClick = {}) {

                    Icon(imageVector = Icons.Default.Notifications, contentDescription ="notification icon" )


                }




            },

            colors = TopAppBarDefaults.topAppBarColors(

                navigationIconContentColor = Color.Cyan,
                containerColor = Color.Blue,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White


            )





        )

        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Pay now")


        }

        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Message us")


        }

        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "call now")


        }
        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Email us")


        }

        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally),


        ) {
            Text(text = "Take a picture")



        }

        Button(
            onClick = {navController.navigate(ROUT_ONBOARDING2)},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Share")


            Icon(imageVector =Icons.Default.Share,
                contentDescription = "share"
            )


        }










    }

}

@Preview(showBackground = true)
@Composable
fun intentscreenPreview() {

    intentscreen(rememberNavController())
}