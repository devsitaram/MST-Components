package com.donation.fda.presentation.ui.dashboard.volunteer_farmer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.donation.fda.presentation.ui.dashboard.donor.HistoryViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.donor.ProfileViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.donor.SettingViewScreenDonor
import com.donation.fda.presentation.ui.navigations.BtnNavScreen
import com.donation.fda.presentation.ui.navigations.volunteerPages
import com.donation.fda.presentation.ui.util.TextView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.backgroundLayoutColor
import com.donation.fda.theme.gray
import com.donation.fda.theme.primaryColor
import com.donation.fda.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteerBtnNavBarViewScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = backgroundLayoutColor, contentColor = primaryColor) {
                volunteerPages.forEach { screen ->
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
        VolunteerNavHostScreen(navController)
    }
}

@Composable
fun VolunteerNavHostScreen(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BtnNavScreen.Home.route) {
        composable(BtnNavScreen.Home.route) {
            HomeViewScreenVolunteer(navController)
        }
        composable(BtnNavScreen.Pending.route) {
            ProfileViewScreenDonor()
        }
        composable(BtnNavScreen.History.route) {
            HistoryViewScreenDonor()
        }
        composable(BtnNavScreen.Profile.route) {
            ProfileViewScreenDonor()
        }
        composable(BtnNavScreen.Setting.route) {
            SettingViewScreenDonor()
        }
    }

    // other screen
//        composable(
//            route = Screen.VideoListScreen.route,
//            arguments = listOf(
//                navArgument(name = SUBJECT_NAME_KEY) {
//                    type = NavType.StringType
//                },
//                navArgument(name = SUBJECT_ID) {
//                    type = NavType.StringType
//                },
//            )
//        ) { navBackStackEntry ->
//            val subjectId = navBackStackEntry.arguments?.getString(SUBJECT_ID)?.toInt()
//            val subject = navBackStackEntry.arguments?.getString(SUBJECT_NAME_KEY)
//            VideoListViewScreen(subjectId, subject, navController)
//        }
//        composable(
//            route = Screen.VideoScreen.route,
//            arguments = listOf(
//                navArgument(name = VIDEO_ID_KEY) {
//                    type = NavType.StringType
//                }
//            )
//        ) { navBackStackEntry ->
//            val videoId = navBackStackEntry.arguments?.getString(VIDEO_ID_KEY)
////            VideoPlayViewScreen(videoId = videoId)
//            VideoViewScreen(videoId)
//        }
//        composable(Screen.TestScreen.route) {
////            TestingViewScreen(navController)
//        }
//    }
}
