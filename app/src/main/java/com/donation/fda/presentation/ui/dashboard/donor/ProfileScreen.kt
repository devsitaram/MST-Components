package com.donation.fda.presentation.ui.dashboard.donor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.PhoneInTalk
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.donation.fda.presentation.ui.util.AsyncImageView
import com.donation.fda.presentation.ui.util.ButtonView
import com.donation.fda.presentation.ui.util.InputTextFieldView
import com.donation.fda.presentation.ui.util.PainterImageView
import com.donation.fda.presentation.ui.util.TextView
import com.donation.fda.presentation.ui.util.TopAppBarIconView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.backgroundLayoutColor
import com.donation.fda.theme.black
import com.donation.fda.theme.gray
import com.donation.fda.theme.primaryColor
import com.donation.fda.theme.red
import com.donation.fda.theme.white
import com.record.fda.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileViewScreenDonor() {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    // checkbox action
    val onClickAction: () -> Unit = {
        scope.launch {
            if (scaffoldState.bottomSheetState.isExpanded) {
                scaffoldState.bottomSheetState.collapse()
            } else {
                scaffoldState.bottomSheetState.expand()
            }
        }
    }

    var profiles by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var adddress by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = 0.dp,
            sheetShape = ShapeDefaults.ExtraLarge,
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),
            sheetContent = {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            IconButton(
                                onClick = { onClickAction() },
                                modifier = Modifier.wrapContentSize()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp),
                                    tint = Color.Gray
                                )
                            }
                        }

                        TextView(
                            text = "Update your profile details!",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        // design
                        Column(modifier = Modifier.fillMaxWidth()) {
                            InputTextFieldView(
                                value = name,
                                onValueChange = { name = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.PersonOutline) },
                                label = "Username",
                                placeholder = "Enter username",
                                isEmptyValue = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            InputTextFieldView(
                                value = email,
                                onValueChange = { email = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.Email) },
                                label = "Email",
                                placeholder = "Enter email",
                                isEmptyValue = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            InputTextFieldView(
                                value = adddress,
                                onValueChange = { adddress = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.LocationOn) },
                                label = "Address",
                                placeholder = "Enter address",
                                isEmptyValue = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            InputTextFieldView(
                                value = phone,
                                onValueChange = { phone = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.PhoneInTalk) },
                                label = "Phone",
                                placeholder = "Enter phone no",
                                isEmptyValue = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            InputTextFieldView(
                                value = gender,
                                onValueChange = { gender = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.Person) },
                                label = "Gender",
                                placeholder = "Enter gender",
                                isEmptyValue = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            InputTextFieldView(
                                value = dob,
                                onValueChange = { dob = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.Cake) },
                                label = "DOB",
                                placeholder = "Enter date of birth",
                                isEmptyValue = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            InputTextFieldView(
                                value = description,
                                onValueChange = { description = it },
                                leadingIcon = { VectorIconView(vectorIcon = Icons.Default.Description) },
                                label = "About",
                                placeholder = "Enter about details",
                                isEmptyValue = false,
                                maxLines = 2,
                                singleLine = false,
                                errorColor = red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )

                            ButtonView(
                                onClick = {
//                                    emailEmptyValue = isEmailEmpty
//                                    passwordEmptyValue = isPasswordEmpty
//                                    if (!isEmailEmpty && !isPasswordEmpty) {
//                                        onClickLogin()
//                                    }
                                },
                                text = "Update",
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = primaryColor,
                                ),
                                textStyle = TextStyle(
                                    color = white,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 15.dp)
                            )
                            Spacer(modifier = Modifier.padding(bottom = 60.dp))
                        }
                    }
                }
            }
        ) { innerPadding ->
            // this is the screen
            Column(modifier = Modifier.padding(innerPadding)) {
                TopAppBarIconView(
                    title = "Profile",
                    modifier = Modifier.shadow(1.dp),
                    backgroundColor = white,
                    contentColor = black,
                    navigationIcon = { PainterImageView(painter = painterResource(id = R.mipmap.img_app_logo)) },
                    vectorIcon = Icons.Default.Edit,
                    tint = gray
                ) { onClickAction() }
                // profile screen
                DonorViewProfile(
                    userId = "101",
                    userName = "Sita Ram Thing",
                    userEmail = "np01ma4s220003@islington.edu.np",
                    userAddress = "Kathmandu, Nepal",
                    userContactNo = "9700110011",
                    userGender = "Male",
                    userDOB = "18-02-2002",
                    aboutsUser = null,
                    profileUrl = "https://image.freepik.com/free-vector/young-volunteer-with-food-donation-donation-box-concept-illustrations-donation-box-donation-volunteers-concept-illustration-set-perfect-banner-mobile-app-landing-page_106796-289.jpg"
                )
            }
        }
    }
}

@Composable
fun DonorViewProfile(
    userId: String? = null,
    userName: String? = null,
    userEmail: String? = null,
    userAddress: String? = null,
    userContactNo: String? = null,
    userGender: String? = null,
    userDOB: String? = null,
    aboutsUser: String? = null,
    profileUrl: String? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .background(backgroundLayoutColor)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 85.dp)
                            .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)),
                        colors = CardDefaults.cardColors(white)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize().background(white)
                                .padding(vertical = 40.dp, horizontal = 8.dp),
                            verticalArrangement = Arrangement.Top,
                        ) {
                            TextView(
                                text = userName.toString(),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 12.dp)
                            )
                            TextView(
                                text = "Donor Id: $userId",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            TextView(
                                text = "Information",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = black,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                            )
                            Divider()
                            UserProfiles(
                                icon = Icons.Default.Email,
                                title = "Email",
                                data = userEmail
                            )
                            UserProfiles(
                                icon = Icons.Default.LocationOn,
                                title = "Address",
                                data = userAddress
                            )
                            UserProfiles(
                                icon = Icons.Default.PhoneInTalk,
                                title = "Contact number",
                                data = userContactNo
                            )
                            UserProfiles(
                                icon = Icons.Default.Person,
                                title = "Gender",
                                data = userGender
                            )
                            UserProfiles(
                                icon = Icons.Default.Cake,
                                title = "Date of Birth",
                                data = userDOB
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp),
                                verticalArrangement = Arrangement.Top,
                            ) {
                                TextView(
                                    text = "About",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = black,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .fillMaxWidth()
                                )
                                Divider()
                                TextView(
                                    text = if (aboutsUser.isNullOrEmpty()) "Add more details to your profile" else aboutsUser.toString(),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = black,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                AsyncImageView(
                    model = profileUrl.toString(),
                    contentScale = ContentScale.Crop,
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                VectorIconView(vectorIcon = icon, tint = gray, modifier = Modifier)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            TextView(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp)
            )
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
}
