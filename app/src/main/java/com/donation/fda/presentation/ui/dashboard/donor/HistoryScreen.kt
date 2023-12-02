package com.donation.fda.presentation.ui.dashboard.donor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.donation.fda.presentation.ui.util.ContentCardView
import com.donation.fda.presentation.ui.util.InputTextFieldView
import com.donation.fda.presentation.ui.util.PainterImageView
import com.donation.fda.presentation.ui.util.TopAppBarIconView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.black
import com.donation.fda.theme.red
import com.donation.fda.theme.white
import com.record.fda.R

@Composable
fun HistoryViewScreenDonor() {
    var searchFieldVisibility by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    val onClickSearch: () -> Unit = {
        searchFieldVisibility = !searchFieldVisibility
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarIconView(
            title = "Profile",
            modifier = Modifier.shadow(1.dp),
            backgroundColor = white,
            contentColor = black,
            navigationIcon = { PainterImageView(painter = painterResource(id = R.mipmap.img_app_logo)) },
            vectorIcon = Icons.Default.Search,
            tint = red
        ) { onClickSearch() }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (searchFieldVisibility) {
                InputTextFieldView(
                    value = searchText,
                    onValueChange = { searchText = it },
                    label = "Search by date",
                    placeholder = "Search",
                    isEmptyValue = false,
                    errorColor = red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            Divider()
            ContentCardView(
                imageUrl = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/ab1fff21308267.57a0ddb7dad63.jpg",
                topic = "Palak Paneer Bhurji",
                donateLocation = "Kamalpokhari",
                distributedLocation = "Baluwatar",
                donationDate = "18-11-2023",
                description = "This Palak Paneer Bhurji is quite viral on the internet these days. My sister tried this recipe and she just loved it.",
                onClickable = { }
            )
            ContentCardView(
                imageUrl = "https://i2-prod.birminghammail.co.uk/incoming/article15866243.ece/ALTERNATES/s615/44588012_10155653433660951_8584327001093963776_n.jpg",
                topic = "Pizza & Burger",
                donateLocation = "Pokhara",
                distributedLocation = "Baglung",
                donationDate = "11-07-2023",
                description = "This Palak Paneer Bhurji is quite viral on the internet these days. My sister tried this recipe and she just loved it.",
                onClickable = { }
            )
            ContentCardView(
                imageUrl = "https://magazine.foodpanda.my/wp-content/uploads/sites/12/2020/01/Dal-Bhat-Tarkari.jpg",
                topic = "Dal Bhat & Achar",
                donateLocation = "Dharan",
                distributedLocation = "Jhapa",
                donationDate = "30-11-2023",
                description = "This Palak Paneer Bhurji is quite viral on the internet these days. My sister tried this recipe and she just loved it.",
                onClickable = { }
            )
            ContentCardView(
                imageUrl = "https://picfiles.alphacoders.com/256/thumb-1920-256644.jpg",
                topic = "Pani Puri & Chatpate",
                donateLocation = "Nepaljung",
                distributedLocation = "Dhangadi",
                donationDate = "20-12-2023",
                description = "This Palak Paneer Bhurji is quite viral on the internet these days. My sister tried this recipe and she just loved it.",
                onClickable = { }
            )
        }
    }
}