package com.donation.fda.presentation.ui.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.donation.fda.data.common.Constants.USER_TYPES

sealed class NavScreen(val route: String) {
    object IntroSliderPage: NavScreen("IntroSlider")
    object WelcomePage: NavScreen("Welcome")
    object LoginPage: NavScreen("Login")
    object RegisterPage: NavScreen("Register")
    object ForgotPasswordPage: NavScreen("ForgotPassword")
    object DashboardPage: NavScreen("Dashboard")

    object Post: NavScreen("post")
}

sealed class BtnNavScreen(val route: String, val title: String, val icon: ImageVector?) {
    object Home : BtnNavScreen("home", "Home", Icons.Default.Home)
    object History : BtnNavScreen("history", "History", Icons.Default.History)
    object Pending : BtnNavScreen("pending", "Pending", Icons.Default.DoneAll)
    object Users : BtnNavScreen("users", "Users", Icons.Default.Groups)
    object Profile : BtnNavScreen("profile", "Profile", Icons.Default.Person)
    object Setting : BtnNavScreen("setting", "Setting", Icons.Default.Settings)
}

// donor items for bottom nav
val donatePages = listOf(
    BtnNavScreen.Home,
    BtnNavScreen.History,
    null,
    BtnNavScreen.Profile,
    BtnNavScreen.Setting
)

// volunteer & farmer items for bottom nav
val volunteerPages = listOf(
    BtnNavScreen.Home,
    BtnNavScreen.Pending,
    BtnNavScreen.History,
    BtnNavScreen.Profile,
    BtnNavScreen.Setting
)

// ngo items for bottom nav
val ngoPages = listOf(
    BtnNavScreen.Home,
    BtnNavScreen.Users,
    BtnNavScreen.History,
    BtnNavScreen.Profile,
    BtnNavScreen.Setting
)