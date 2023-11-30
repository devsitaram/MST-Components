package com.donation.fda.presentation.ui.dashboard.donor

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.OfflineBolt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.PhoneInTalk
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.donation.fda.presentation.ui.RegisterView
import com.donation.fda.presentation.ui.UserList
import com.donation.fda.presentation.ui.util.ButtonView
import com.donation.fda.presentation.ui.util.CardView
import com.donation.fda.presentation.ui.util.CircularImageView
import com.donation.fda.presentation.ui.util.ImageViewPainter
import com.donation.fda.presentation.ui.util.InputTextFieldView
import com.donation.fda.presentation.ui.util.TextView
import com.donation.fda.presentation.ui.util.TopAppBarView
import com.donation.fda.presentation.ui.util.TopButtonAppBarView
import com.donation.fda.presentation.ui.util.VectorIconView
import com.donation.fda.theme.PurpleGrey80
import com.donation.fda.theme.backgroundLayoutColor
import com.donation.fda.theme.black
import com.donation.fda.theme.blue
import com.donation.fda.theme.gray
import com.donation.fda.theme.primaryColor
import com.donation.fda.theme.red
import com.donation.fda.theme.skyBlue
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

    var profileUrl by remember { mutableStateOf("") }
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
                            .padding(10.dp),
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
                                placeholder = "Enter description",
                                isEmptyValue = false,
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
                                    .padding(horizontal = 10.dp, vertical = 10.dp)
                            )

                        }
                    }
                }
            }
        ) { innerPadding ->
            // this is the screen
            Column(modifier = Modifier.padding(innerPadding)) {
                // profile screen
                DonorViewProfile(
                    onClickAction = {
                        onClickAction()
                    }
                )
            }
        }
    }
}

@Composable
fun DonorViewProfile(onClickAction: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .background(backgroundLayoutColor)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarView(
            title = "Profile",
            modifier = Modifier,
            backgroundColor = white,
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
                            IconButton(onClick = { onClickAction() }) {
                                VectorIconView(vectorIcon = Icons.Default.Edit, tint = gray)
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 30.dp)
                            .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)),
                        colors = CardDefaults.cardColors(white)
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
                                text = "Donor Id: 101",
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
                                data = "np01ma4s220003@islington.edu.np"
                            )
                            UserProfiles(
                                icon = Icons.Default.LocationOn,
                                title = "Address",
                                data = "Kathmandu, Nepal"
                            )
                            UserProfiles(
                                icon = Icons.Default.PhoneInTalk,
                                title = "Phone number",
                                data = "9700110011"
                            )
                            UserProfiles(
                                icon = Icons.Default.Person,
                                title = "Gender",
                                data = "Male"
                            )
                            UserProfiles(
                                icon = Icons.Default.Cake,
                                title = "Date of Birth",
                                data = null
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
                                val descriptions: String? = null
                                TextView(
                                    text = if (descriptions.isNullOrEmpty()) "Add more details to your profile" else descriptions.toString(),
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
