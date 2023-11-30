package com.donation.fda.presentation.ui.dashboard.donor

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.OfflineBolt
import androidx.compose.material.icons.filled.PhoneInTalk
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.donation.fda.presentation.ui.util.CardView
import com.donation.fda.presentation.ui.util.CircularImageView
import com.donation.fda.presentation.ui.util.ImageViewPainter
import com.donation.fda.presentation.ui.util.TextView
import com.donation.fda.presentation.ui.util.TopAppBarView
import com.donation.fda.presentation.ui.util.TopButtonAppBarView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.backgroundLayoutColor
import com.donation.fda.theme.black
import com.donation.fda.theme.gray
import com.donation.fda.theme.primaryColor
import com.record.fda.R

@Composable
fun ProfileViewScreenDonor() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarView(
            title = "Profile",
            modifier = Modifier,
            backgroundColor = backgroundLayoutColor,
            contentColor = black
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            VectorIconView(vectorIcon = Icons.Default.Edit, tint = gray)
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)),
                        colors = CardDefaults.cardColors(backgroundLayoutColor)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 40.dp, horizontal = 8.dp),
                            verticalArrangement = Arrangement.Top,
                        ) {
                            TextView(
                                text = "Sita Ram Thing",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 12.dp)
                            )
                            TextView(
                                text = "Donor",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                            )

                            UserProfiles(icon = Icons.Default.DateRange, title = "Date of Birth", data = null)
                            UserProfiles(icon = Icons.Default.Email, title = "Email", data = "np01ma4s220003@islington.edu.np")
                            UserProfiles(icon = Icons.Default.LocationOn, title = "Address", data = "Kathmandu, Nepal")
                            UserProfiles(icon = Icons.Default.PhoneInTalk, title = "Phone number", data = "9700110011")
                            UserProfiles(icon = Icons.Default.DateRange, title = "Date of Birth", data = null)
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                CircularImageView(
                    painter = painterResource(id = R.mipmap.img_profile),
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun UserProfiles(
    icon: ImageVector,
    title: String,
    data: String? = null
) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 12.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            VectorIconView(vectorIcon = icon, tint = gray)
            TextView(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp)
            )
        }
        TextView(
            text = if (data.isNullOrEmpty()) "Not found" else data.toString(),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp)
        )
    }
}
