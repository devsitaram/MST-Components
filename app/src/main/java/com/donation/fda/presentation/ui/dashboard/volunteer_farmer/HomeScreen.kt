package com.donation.fda.presentation.ui.dashboard.volunteer_farmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.donation.fda.presentation.ui.util.TopButtonAppBar
import com.donation.fda.theme.white

@Composable
fun HomeViewScreenVolunteer(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white).padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopButtonAppBar("Home")
        LazyColumn(
            content = {
                items(30) {count ->
                    Text(text = "$count Volunteer HomeScreen", color = Color.Black)
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    Divider()
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                }
            }
        )
    }
}