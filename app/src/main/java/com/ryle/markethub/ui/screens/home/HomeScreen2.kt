package com.ryle.markethub.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.navigation.ROUT_HOME
import com.ryle.markethub.navigation.ROUT_INTENT
import com.ryle.markethub.navigation.ROUT_ONBOARDING2
import com.ryle.markethub.navigation.ROUT_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen2(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(

        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="") }
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Default.Info, contentDescription ="") }
                }

            )
        },



        //BottomBar
        bottomBar = {

            NavigationBar(
                containerColor = Color.Blue
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_INTENT)
                    }
                )


                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Home") },
                    label = { Text("Info") },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_HOME)
                    }
                )



            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Color.Blue
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },

        //Contents

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                // .background(newYellow)
            ) {


                //Main Contents of the page


                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {

                    Image(

                        painter = painterResource(com.ryle.markethub.R.drawable.product1),
                        contentDescription = "this is a product",
                        modifier = Modifier.height(300.dp).width(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop


                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Image(

                        painter = painterResource(com.ryle.markethub.R.drawable.img),
                        contentDescription = "this is a product",
                        modifier = Modifier.height(300.dp).width(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop



                    )
                    Spacer(modifier = Modifier.width(20.dp))


                    Image(

                        painter = painterResource(com.ryle.markethub.R.drawable.img_1),
                        contentDescription = "this is a product",
                        modifier = Modifier.height(300.dp).width(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop



                    )
                    Spacer(modifier = Modifier.width(20.dp))


                    Image(

                        painter = painterResource(com.ryle.markethub.R.drawable.img_2),
                        contentDescription = "this is a product",
                        modifier = Modifier.height(300.dp).width(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop



                    )






                }
                //end of row

                Spacer(modifier = Modifier.width(40.dp))

                Button(
                    onClick = {navController.navigate(ROUT_REGISTER)},
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(250.dp)
                ) {
                    Text(text = "Get started")


                }











































            }
        }
    )

    //End of scaffold






}

@Preview(showBackground = true)
@Composable

fun HomeScreen2Preview() {

    HomeScreen2(rememberNavController())
}