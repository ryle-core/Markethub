package com.ryle.markethub.ui.screens.intent

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.navigation.ROUT_INTENT
import com.ryle.markethub.navigation.ROUT_ONBOARDING2
import com.ryle.markethub.navigation.ROUT_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun intentscreen(navController: NavController){

    val mContext = LocalContext.current





    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TopAppBar(
            title = {   Text(text = "Android Intent")},

            navigationIcon = {

                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            },

            actions = {

                IconButton(onClick = {}) {

                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="a shopping cart" )


                }

                IconButton(onClick = {navController.navigate(ROUT_REGISTER)}) {

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
            onClick = {




                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }


            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Pay now")
            Icon(imageVector =Icons.Default.Done,
                contentDescription = "share"
            )


        }

        Button(
            onClick = {



                val smsIntent= Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0720245837".toUri()
                smsIntent.putExtra("sms_body","Hello Glory,how was your day?")
                mContext.startActivity(smsIntent)


                },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Message us")
            Spacer(modifier = Modifier.width(11.dp))
            Icon(imageVector =Icons.Default.MailOutline,
                contentDescription = "message"
            )


        }

        Button(
            onClick = {

                val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0720245837".toUri()
                mContext.startActivity(callIntent)



            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "call now")
            Spacer(modifier = Modifier.width(11.dp))
            Spacer(modifier = Modifier.width(11.dp))
            Icon(imageVector =Icons.Default.Call,
                contentDescription = "share"
            )


        }
        Button(
            onClick = {

                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                mContext.startActivity(shareIntent)
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Email us")
            Spacer(modifier = Modifier.width(11.dp))
            Icon(imageVector =Icons.Default.Email,
                contentDescription = "email"
            )



        }

        Button(
            onClick = {

                val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                    mContext.startActivity(cameraIntent)
                }else{
                    println("Camera app is not available")
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally),


        ) {
            Text(text = "Take a picture")
            Spacer(modifier = Modifier.width(11.dp))
            Icon(imageVector =Icons.Default.Person,
                contentDescription = "picture"
            )





        }

        Button(
            onClick = {

                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://github.com/gloryakinyi")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(250.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Share")
            Spacer(modifier = Modifier.width(11.dp))

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