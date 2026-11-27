package com.ryle.markethub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.data.AuthViewModel
import com.ryle.markethub.ui.screens.auth.Loginscreen
import com.ryle.markethub.ui.screens.auth.Registerscreen
import com.ryle.markethub.ui.screens.home.HomeScreen2
import com.ryle.markethub.ui.screens.home.Homescreen
import com.ryle.markethub.ui.screens.intent.intentscreen
import com.ryle.markethub.ui.screens.onboarding.Onboardingscreen1
import com.ryle.markethub.ui.screens.onboarding.Onboardingscreen2
import com.ryle.markethub.ui.screens.onboarding.Onboardingscreen3
import com.ryle.markethub.ui.screens.orders.OrderUploadScreen
import com.ryle.markethub.ui.screens.orders.ViewOrdersScreen
import com.ryle.markethub.ui.screens.scaffold.ScaffoldScreen
import com.ryle.markethub.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {


        composable(ROUT_HOME) {
            Homescreen(navController)
        }


        composable(ROUT_LOGIN) {
            Loginscreen(navController)
        }


        composable(ROUT_REGISTER) {
            Registerscreen(
                onRegister = { username, email, password, confirmPassword ->

                    val context = navController.context
                    val authViewModel = AuthViewModel(navController, context)

                    authViewModel.signup(
                        username,
                        email,
                        password,
                        confirmPassword
                    )
                },navController
            )
        }





                composable(ROUT_ONBOARDING1) {
                    Onboardingscreen1(navController)
                }


                    composable(ROUT_ONBOARDING2) {
                        Onboardingscreen2(navController)
                    }

        composable(ROUT_ONBOARDING3) {
            Onboardingscreen3(navController)
        }



        composable(ROUT_INTENT) {
            intentscreen(navController)
        }




        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }


        composable(ROUT_SCAFFOLD) {
            ScaffoldScreen(navController)
        }


        composable(ROUT_HOMESCREEN2) {
            HomeScreen2(navController)
        }


        composable(ROUT_UPLOAD_ORDER) {
            OrderUploadScreen(navController)
        }

        composable(ROUT_VIEW_ORDER) {
            ViewOrdersScreen(navController)
        }
























    }



}