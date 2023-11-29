package com.donation.fda.presentation.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.donation.fda.presentation.ui.ForgotPasswordViewScreen
import com.donation.fda.presentation.ui.IntroSliderViewScreen
import com.donation.fda.presentation.ui.LoginViewScreen
import com.donation.fda.presentation.ui.RegisterViewScreen
import com.donation.fda.presentation.ui.WelcomeViewScreen
import com.donation.fda.presentation.ui.dashboard.donor.DonorBtnNavBarViewScreen
import com.donation.fda.presentation.ui.dashboard.ngo.NgoBtnNavBarViewScreen
import com.donation.fda.presentation.ui.dashboard.volunteer_farmer.VolunteerBtnNavBarViewScreen

@Composable
fun NavigationViewScreen(
    getInstallDevice: String?,
    authToken: String?,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =
        if (getInstallDevice.isNullOrEmpty()) {
            NavScreen.IntroSliderPage.route
        } else {
            if (authToken.isNullOrEmpty()) {
                NavScreen.LoginPage.route
            } else {
                when (authToken.toString()) {
                    "Donors" -> {
                        NavScreen.DonorDashboardPage.route
                    }
                    "NGOs" -> {
                        NavScreen.NgoDashboardPage.route
                    }
                    else -> {
                        NavScreen.VolunteerDashboardPage.route
                    }
                }
            }
        }
    ) {
        composable(NavScreen.IntroSliderPage.route) {
            IntroSliderViewScreen(navController)
        }

        composable(NavScreen.WelcomePage.route) {
            WelcomeViewScreen(navController)
        }

        composable(NavScreen.LoginPage.route) {
            LoginViewScreen(navController)
        }

        composable(NavScreen.RegisterPage.route) {
            RegisterViewScreen(navController)
        }

        composable(NavScreen.ForgotPasswordPage.route) {
            ForgotPasswordViewScreen(navController)
        }

        // donor
        composable(NavScreen.DonorDashboardPage.route) {
            DonorBtnNavBarViewScreen(navController)
        }

        // volunteer
        composable(NavScreen.VolunteerDashboardPage.route) {
            VolunteerBtnNavBarViewScreen(navController)
        }

        // ngo
        composable(NavScreen.NgoDashboardPage.route) {
            NgoBtnNavBarViewScreen(navController)
        }
    }
}
