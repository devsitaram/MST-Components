package com.donation.fda.presentation.ui.util

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.donation.fda.theme.pink
import com.donation.fda.theme.primaryColor
import com.donation.fda.theme.white
import com.record.fda.R

@Composable
fun TextView (
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun ClickableTextView(
    text: String,
    style: TextStyle = TextStyle(),
    softWrap: Boolean = false,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: ((TextLayoutResult) -> Unit),
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    ClickableText(
        text = AnnotatedString(text),
        modifier = modifier,
        style = style,
        softWrap = softWrap,
        overflow = overflow,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        onClick = onClick,
    )
}

// material button 3
@Composable
fun ButtonView(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    text: String,
    textStyle: TextStyle = TextStyle(),
    enabled: Boolean = true,
    shape: Shape = ShapeDefaults.Medium,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = colors,
        enabled = enabled,
        shape = shape,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding
    ) {
        TextView(text = text, style = textStyle, modifier = Modifier.padding(3.dp))
    }
}

// text button
@Composable
fun TextButtonView(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = TextStyle.Default,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
    ) {
        TextView(text = text, style = textStyle, modifier = Modifier)
    }
}

// input text fields
@SuppressLint("ModifierParameter")
@Composable
fun InputTextFieldView(
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    leadingIcon: @Composable() (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    textStyle: TextStyle = TextStyle.Default,
    isEmptyValue: Boolean = false,
    isInvalidValue: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    shape: Shape = ShapeDefaults.Medium,
    errorValue: Boolean? = null,
    invalidMessage: String? = null,
    errorColor: Color = Color.Unspecified
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { TextView(text = label.toString(), style = textStyle) },
            placeholder = {
                TextView(
                    text = placeholder.toString(),
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 24.sp
                    ),
                    modifier = Modifier
                )
            },
            trailingIcon = null,
            leadingIcon = leadingIcon,
            enabled = enabled,
            readOnly = readOnly,
            keyboardOptions = keyboardOptions,// KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = singleLine,
            maxLines = maxLines,
            shape = shape,
            isError = (isEmptyValue || isInvalidValue),
            modifier = modifier
        )
        if (isEmptyValue) {
            TextView(
                text = "The $label is empty!",
                style = TextStyle(color = errorColor),
                modifier = Modifier.padding(start = 5.dp, top = 2.dp)
            )
        }
        if (isInvalidValue) {
            TextView(
                text = invalidMessage.toString(),
                style = TextStyle(color = errorColor),
                modifier = Modifier.padding(start = 5.dp, top = 2.dp)
            )
        }
    }
}

// password input text fields
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ModifierParameter")
@Composable
fun PasswordTextFieldView(
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    leadingIcon: @Composable() (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    textStyle: TextStyle = TextStyle.Default,
    isEmptyValue: Boolean = false,
    isError: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    shape: Shape = ShapeDefaults.Medium,
    errorMessage: String? = null,
    errorColor: Color = Color.Unspecified,
) {
    val passwordVisibility = remember { mutableStateOf(false) }
    var color by remember { mutableStateOf(primaryColor) }
    color = if (isEmptyValue) {
        errorColor
    } else {
        primaryColor
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { TextView(text = label.toString(), style = textStyle) },
        placeholder = {
            TextView(
                text = placeholder.toString(),
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 24.sp
                ),
                modifier = Modifier
            )
        },
        enabled = enabled,
        shape = shape,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        leadingIcon = leadingIcon,
        trailingIcon = {
            IconButton(
                onClick = { passwordVisibility.value = !passwordVisibility.value },
            ) {
                VectorIconView(
                    imageVector = if (passwordVisibility.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    tint = if (isEmptyValue || isError) Color.Red else primaryColor
                )
            }
        },
        isError = (isEmptyValue || isError),
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = modifier,
    )

    if (isEmptyValue) {
        TextView(
            text = "The $label is empty!",
            style = TextStyle(color = errorColor, textAlign = TextAlign.Start),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 1.dp)
        )
    }
    if (isError) {
        TextView(
            text = errorMessage.toString(),
            style = TextStyle(color = errorColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 1.dp)
        )
    }
}

@Composable
fun CheckboxComponent(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors(),
    checkedState: Boolean, // Remove the remember here
    onClick: (Boolean) -> Unit // Update the onClick lambda to pass the Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { onClick(it) }, // Pass the updated value to the onClick lambda
            modifier = Modifier,
            enabled = enabled,
            colors = colors,
        )
        TextView(text = if (checkedState) "Remember" else "Remember Me")
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun PainterImageView(
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = Float.MAX_VALUE,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun AsyncImageView(
    model: Any,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    transform: (AsyncImagePainter.State) -> AsyncImagePainter.State = { it },
    onState: ((AsyncImagePainter.State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = 1.0f,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = FilterQuality.None
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier,
        transform = transform,
        onState = onState,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun VectorIconView(
    imageVector: ImageVector,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun RoundedCornerCardView(
    modifier: Modifier = Modifier,
    shape: Shape = ShapeDefaults.Small,
    painter: Painter,
    onClick: () -> Unit
) {
    Card(
        shape = shape,
        modifier = modifier.clickable { onClick() },
    ) {
        Image(painter = painter, modifier = Modifier.size(30.dp), contentDescription = null)
    }
}

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.Transparent,
    backgroundColor: Color = Color.Transparent,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = modifier,
            color = color,
            backgroundColor = backgroundColor
        )
    }
}

@Composable
fun MessageDialogBox(
    title: String? = null,
    descriptions: String? = null,
    onDismiss: () -> Unit,
    btnText: String? = null,
    color: Color = Color.Transparent,
) {
    AlertDialog(
        title = {
            TextView(
                text = title.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = color,
                modifier = Modifier.fillMaxWidth()
            )
        },
        onDismissRequest = { onDismiss() },
        text = {
            TextView(
                text = descriptions.toString(),
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        },
        modifier = Modifier.fillMaxWidth(),
        confirmButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonView(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(color),
                    text = btnText.toString(),
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    ),
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonAppBar(
    title: String,
    navController: NavHostController
) {
    TopAppBar(
        title = { TextView(text = title) },
        navigationIcon = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 10.dp, end = 10.dp)
                    .width(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PainterImageView(
                    painter = painterResource(id = R.mipmap.img_distribute_food),
                    modifier = Modifier.size(40.dp),
                    contentDescription = null
                )
                TextView(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    // search icon
                    /**navController.navigate(ScreenList.SearchScreen.route)*/
                    /**navController.navigate(ScreenList.SearchScreen.route)*/
                    /**navController.navigate(ScreenList.SearchScreen.route)*/
                    /**navController.navigate(ScreenList.SearchScreen.route)*/
                    VectorIconView(
                        imageVector = Icons.Default.Search,
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { /**navController.navigate(ScreenList.SearchScreen.route)*/ },
                    )
                    // notification icon
                    IconButton(
                        onClick = { /**navController.navigate(ScreenList.Notification.route)*/ },
                        modifier = Modifier
                    ) {
                        BottomNavigationItem(
                            icon = {
                                BadgedBox(
                                    badge = {
                                        Badge(backgroundColor = pink, contentColor = white) {
                                            TextView(
                                                text = "3",
                                                style = TextStyle(
                                                    color = white,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Normal
                                                ),
                                                modifier = Modifier
                                            )
                                        }
                                    }
                                ) {
                                    VectorIconView(
                                        Icons.Filled.Notifications,
                                        contentDescription = "Notification",
                                        tint = Color.Gray
                                    )
                                }
                            },
                            selected = false,
                            onClick = { },
                            modifier = Modifier,
                        )
                    }
                }
            }
        },
        modifier = Modifier
            .shadow(5.dp)
            .height(56.dp)
            .fillMaxWidth(),
    )
}

//@Composable
//fun ContentCardView(
//    imageUrl: String,
//    topic: String,
//    description: String,
//    onClickable: () -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth().wrapContentHeight()
//            .padding(bottom = 15.dp)
//            .border(1.dp, Color.LightGray)
//            .clickable { onClickable() },
//        shape = ShapeDefaults.Medium
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            AsyncImage(
//                model = imageUrl,
//                contentDescription = null,
//                modifier = Modifier
//                    .size(120.dp)
//                    .padding(start = 15.dp, end = 15.dp)
//            )
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .border(1.dp, Color.LightGray),
//                verticalArrangement = Arrangement.Bottom
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(15.dp)
//                ) {
//                    TextView(
//                        text = topic, style = TextStyle(
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Bold,
//                        ),
//                        modifier = Modifier
//                    )
//                    TextView(
//                        text = description,
//                        style = TextStyle(
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Normal,
//                            lineHeight = 20.sp,
//                            color = Color.Gray
//                        ),
//                        modifier = Modifier.padding(top = 5.dp)
//                    )
//                }
//                Spacer(modifier = Modifier.padding(top = 20.dp))
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .border(1.dp, Color.LightGray)
//                        .padding(10.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Newspaper,
//                        contentDescription = null,
//                        tint = skyBlue,
//                        modifier = Modifier.padding(start = 5.dp)
//                    )
//                    TextView(
//                        text = "View Package Detail", style = TextStyle(
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.SemiBold,
//                            color = skyBlue
//                        ),
//                        modifier = Modifier.padding(start = 5.dp)
//                    )
//                }
//            }
//        }
//    }
// }

@Composable
fun DividerWithText(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.width(140.dp))
        Text(text = text, color = Color.Gray)
        Divider(modifier = Modifier.width(140.dp))
    }
}

@Composable
fun ImageViewPainter(
    painterImage: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterImage,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun CanvasView(
    modifier: Modifier = Modifier,
    left: Float = 0f,
    top: Float = 0f,
    color: Color = Color.Unspecified,
    radius: Float = 0f,
    center: Offset = Offset(0f, 0f), // Default center at (0, 0)
    alpha: Float = 1f, // Default alpha fully opaque
    style: DrawStyle = Fill, // Default draw style as Fill
    colorFilter: ColorFilter? = null, // Default no color filter
    blendMode: BlendMode = BlendMode.SrcOver // Default blend mode
) {
    Canvas(modifier = modifier) {
        translate(left = left, top = top) {
            drawCircle(
                color = color,
                radius = radius,
                center = center,
                alpha = alpha,
                style = style,
                colorFilter = colorFilter,
                blendMode = blendMode
            )
        }
    }
}

// graphic design
//@Composable
//fun CanvasExample() {
//    Canvas(modifier = Modifier.size(100.dp)) {
//        translate(left = 400f, top = -100f) {
//            drawCircle(Color.Blue, radius = 200.dp.toPx())
//        }
//    }
//}

@Composable
fun LottieAnimationsView(
    rawResource: Int,
    isAnimating: Boolean = true,
    speed: Float = 0.75f,
    modifier: Modifier = Modifier
) {
    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(rawResource))
    val progress by animateLottieCompositionAsState(
        composition = compositionResult.value,
        isPlaying = isAnimating,
        iterations = LottieConstants.IterateForever,
        speed = speed
    )
    LottieAnimation(
        composition = compositionResult.value,
        progress = progress,
        modifier = modifier
    )
}