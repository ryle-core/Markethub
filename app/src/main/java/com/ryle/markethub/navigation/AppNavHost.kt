package com.ryle.markethub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ryle.markethub.ui.screens.auth.Loginscreen
import com.ryle.markethub.ui.screens.auth.Registerscreen
import com.ryle.markethub.ui.screens.home.Homescreen
import com.ryle.markethub.ui.screens.onboarding.Onboardingscreen1
import com.ryle.markethub.ui.screens.onboarding.Onboardingscreen2
import com.ryle.markethub.ui.screens.onboarding.Onboardingscreen3

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_HOME
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
                Registerscreen(navController)
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















    }
}