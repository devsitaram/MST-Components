package com.donation.fda.presentation.ui.dashboard.ngo

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.donation.fda.presentation.ui.dashboard.donor.HistoryViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.donor.PostViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.donor.ProfileViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.donor.SettingViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.volunteer_farmer.HomeViewScreenVolunteer
import com.donation.fda.presentation.ui.navigations.BtnNavScreen
import com.donation.fda.presentation.ui.navigations.ngoPages
import com.donation.fda.presentation.ui.navigations.volunteerPages
import com.donation.fda.presentation.ui.util.PainterImageView
import com.donation.fda.presentation.ui.util.TextView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.backgroundLayoutColor
import com.donation.fda.theme.gray
import com.donation.fda.theme.primaryColor
import com.donation.fda.theme.white


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NgoBtnNavBarViewScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = backgroundLayoutColor, contentColor = primaryColor) {
                ngoPages.forEach { screen ->
                    BottomNavigationItem(
                        modifier = Modifier
                            .background(color = white),
                        icon = {
                            screen.icon?.let {
                                VectorIconView(vectorIcon = it,
                                    tint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                        primaryColor // Change to your desired color
                                    } else {
                                        gray
                                    }
                                )
                            }
                        },
                        label = {
                            TextView(
                                text = screen.title,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                    primaryColor
                                } else {
                                    gray
                                }
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            screen.let {
                                navController.navigate(it.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) {
        NgoNavHostScreen(navController)
    }
}

@Composable
fun NgoNavHostScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BtnNavScreen.Home.route) {
        composable(BtnNavScreen.Home.route) {
            HomeViewScreenVolunteer(navController)
        }

        composable(BtnNavScreen.History.route) {
            HistoryViewScreenDonor()
        }
        composable(BtnNavScreen.Users.route) {
            PostViewScreenDonor()
        }
        composable(BtnNavScreen.Profile.route) {
            ProfileViewScreenDonor()
        }
        composable(BtnNavScreen.Setting.route) {
            SettingViewScreenDonor()
        }
    }
}