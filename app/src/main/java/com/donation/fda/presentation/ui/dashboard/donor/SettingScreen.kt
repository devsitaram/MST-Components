package com.donation.fda.presentation.ui.dashboard.donor

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Update
import androidx.compose.material.icons.filled.WifiProtectedSetup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.donation.fda.presentation.ui.navigations.BtnNavScreen
import com.donation.fda.presentation.ui.navigations.NavScreen
import com.donation.fda.presentation.ui.util.CardView
import com.donation.fda.presentation.ui.util.ConfirmationDialogBox
import com.donation.fda.presentation.ui.util.PainterImageView
import com.donation.fda.presentation.ui.util.TextView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.backgroundLayoutColor
import com.donation.fda.theme.black
import com.donation.fda.theme.gray
import com.donation.fda.theme.primaryColor
import com.donation.fda.theme.white
import com.record.fda.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingViewScreenDonor(navLoginController: NavHostController) {

    var isLogout by remember { mutableStateOf(false) }

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val snackBar = { scope.launch { snackBarHostState.showSnackbar("Nothing update of system.") } }

    Scaffold(
        snackbarHost = {
            Box(modifier = Modifier.fillMaxSize().padding(top = 100.dp), contentAlignment = Alignment.Center) {
                SnackbarHost(hostState = snackBarHostState)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(white)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(white)
                    .padding(horizontal = 8.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PainterImageView(
                        painter = painterResource(id = R.mipmap.img_profile),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Column(
                        modifier = Modifier.padding(start = 10.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TextView(
                            text = "Sita Ram Thing",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.Default,
                                color = primaryColor
                            ),
                            modifier = Modifier
                        )
                        TextView(
                            text = "np01ma4s220003@lslingtoncollege.edu.np",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 20.sp,
                                color = black
                            ),
                            modifier = Modifier
                        )
                    }
                }
                CardView(
                    image = painterResource(id = R.mipmap.img_app_logo),
                    text = "Food Share",
                    description = "I'm a Donor",
                    color = backgroundLayoutColor
                )
            }
            Column(modifier = Modifier.padding(bottom = 50.dp)) {
                Divider(modifier = Modifier.height(1.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundLayoutColor), // horizontal = 8.dp, vertical = 16.dp
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    VectorIconView(
                        vectorIcon = Icons.Default.WifiProtectedSetup,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
                        tint = gray
                    )
                    Column {
                        TextView(
                            text = "Latest version",
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = black
                        )
                        TextView(
                            text = "v1.1.4",
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = gray
                        )
                    }
                }
                SettingsList(
                    vectorIcon = Icons.Default.Feedback,
                    text = "Send Feedback",
                    color = black,
                    onClick = {}
                )
                SettingsList(
                    vectorIcon = Icons.Default.DarkMode,
                    text = "Dark mode",
                    color = black,
                    onClick = {}
                )
                SettingsList(
                    vectorIcon = Icons.Default.Info,
                    text = "Information",
                    color = black,
                    onClick = {
                        snackBar()
                    }
                )
                SettingsList(
                    vectorIcon = Icons.AutoMirrored.Filled.Logout,
                    text = "Log out",
                    color = black,
                    onClick = {
                        isLogout = true
                    }
                )
            }
        }

        if (isLogout) {
            ConfirmationDialogBox(
                title = "Log Out?",
                text = "Are your sure you want to log out?",
                onDismiss = { isLogout = false },
                onConfirm = {
                    navLoginController.navigate(NavScreen.LoginPage.route) {
                        popUpTo(BtnNavScreen.Setting.route) {
                            inclusive = true
                            isLogout = false
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun SettingsList(vectorIcon: ImageVector, text: String, color: Color, onClick: () -> Unit) {
    Divider(modifier = Modifier.height(1.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth() // horizontal = 8.dp, vertical = 16.dp
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        VectorIconView(
            vectorIcon = vectorIcon,
            tint = gray,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
        )
        TextView(
            text = text,
            fontStyle = FontStyle.Normal,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = color
        )
    }
}