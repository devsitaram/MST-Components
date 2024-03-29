package com.donation.fda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.donation.fda.data.common.ClientInterceptors
import com.donation.fda.presentation.ui.dashboard.donor.HistoryViewScreenDonor
import com.donation.fda.presentation.ui.dashboard.donor.ProfileViewScreenDonor
import com.donation.fda.presentation.ui.navigations.NavigationViewScreen
import com.donation.fda.theme.FDATheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create the Shared Preferences
        val getSharedPreferences = ClientInterceptors(this)
        val getInstallDevice = getSharedPreferences.installApp()
        val authToken = getSharedPreferences.authToken()

        setContent {
            FDATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    DonorBtnNavBarViewScreen()
//                    VolunteerBtnNavBarViewScreen()
//                    HistoryViewScreenDonor()
//                    ProfileViewScreenDonor()
                    NavigationViewScreen(getInstallDevice, authToken)
                }
            }
        }
    }
}