package com.example.composetestproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.model.SportModel

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId: String = "Email",
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    leadingIcon: Painter,
    onAction: KeyboardActions = KeyboardActions.Default
) {

    InputField(
        modifier = modifier,
        valueState = emailState,
        labelId = labelId,
        enabled = enabled,
        keyboardType = KeyboardType.Email,
        imeAction = imeAction,
        leadingIcon = leadingIcon,
        onAction = onAction
    )
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    leadingIcon: Painter,
//    trailingIcon: Painter,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = {
            Text(
                text = labelId, color = Color(0xff65656B)
            )
        },
        singleLine = isSingleLine,
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color(0xff65656B)
        ),
        modifier = modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(15.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        leadingIcon = {
            Icon(
                painter = leadingIcon,
                contentDescription = "TextField Leading Icon",
                modifier = Modifier.size(25.dp)
            )
        },
        //#65656B
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xff222232),
            backgroundColor = Color(0xff181829),
            leadingIconColor = Color(0xff65656B)
        )
    )
}

@Composable
fun PasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    onAction: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Done,
    leadingIcon: Painter,
    function: () -> Unit
) {
    val visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {
            passwordState.value = it
        },
        label = { Text(
            text = labelId, color = Color(0xff65656B)
        ) },
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp, color = Color(0xff65656B)),
        modifier = modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(15.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ), visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                painter = leadingIcon,
                contentDescription = "TextField Leading Icon",
                modifier = Modifier.size(25.dp)
            )
        },
        trailingIcon = { PasswordVisibility(passwordVisibility = passwordVisibility) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xff222232),
            backgroundColor = Color(0xff181829),
            leadingIconColor = Color(0xff65656B)
        ),
        keyboardActions = onAction
    )

}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val visible = passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value = !visible}) {
//        Image(painter = painterResource(id = R.drawable.password), contentDescription = "")
//        Icon(imageVector = Icons.Default.Visible, contentDescription = )
    }
}

@Composable
fun ScoreCardComponent(
    fTeamImage: Int,
    sTeamImage: Int,
    fTeamName: String,
    sTeamName: String,
    fTeamScore: String,
    secTeamScore: String,
    dur: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Column() {
            Surface(
                color = colorResource(id = com.example.composetestproject.R.color.score_card_color), modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(0.85f)
                    .clip(
                        RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp)
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 13.dp)
                ) {
                    Row() {
                        TeamIcon(fTeamImage)
                        Spacer(modifier = Modifier.width(3.dp))
                        TeamIcon(sTeamImage)
                    }
                    Row {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = fTeamName, color = Color.White)
                            Text(text = fTeamScore, color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "vs", color = Color.White)
                            Text(text = "-", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(5.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = sTeamName, color = Color.White)
                            Text(text = secTeamScore, color = Color.White)
                        }
                    }
                }

            }
        }
        Surface(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)), color = colorResource(
                id = com.example.composetestproject.R.color.sub_background
            )
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = dur, textAlign = TextAlign.Center, color = Color.White)

            }
        }
    }
}

@Composable
fun LeagueCountryComponent(flag: Int, league: String, country: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = flag),
                contentDescription = "Country flag",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = league,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 15.sp
                )
                Text(text = country, color = Color.White, fontSize = 12.sp)
            }
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Arrow Forward", tint = Color.White
        )
    }
}

@Composable
fun TeamIcon(team: Int) {
    Surface(
        modifier = Modifier.size(38.dp), shape = CircleShape, color = colorResource(
            id = com.example.composetestproject.R.color.sub_background
        )
    ) {
        Image(
            painter = painterResource(id = team),
            contentDescription = "Team Image",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun SportRectangularCard(item: SportModel, color: Int, onClick: ()-> Unit) {
    Surface(modifier = Modifier
        .width(152.dp)
        .height(142.dp)
        .padding(end = 20.dp)
        .clickable { onClick.invoke() },
        shape = RoundedCornerShape(15.dp),
        color = colorResource(
            id = color
        )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Sport Icon",
                modifier = Modifier.size(52.dp)
            )
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun SportyAppBar(title: String,
                 icon: ImageVector? = null,
                 navController: NavController,
                 onBackArrowClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.padding(top = 40.dp), title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (icon != null) {
                    Icon(imageVector = icon,
                        contentDescription = "Arrow Back",
                        tint = Color.Red.copy(alpha = 0.7f),
                        modifier = Modifier.clickable { onBackArrowClick.invoke() })

                }
                if (icon != null) {
                    Spacer(modifier = Modifier.width(40.dp))
                }
                Text(
                    text = title,
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 23.sp)
                )
//                          Spacer(modifier = Modifier.width(150.dp))
            }
        },
        actions = {
            if (icon == null) {
                Row() {
                    IconButton(
                        modifier = Modifier.padding(3.dp),
                        onClick = {
//
                        }) {
                        Icon(
                            painter = painterResource(id = com.example.composetestproject.R.drawable.search),
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )

                    }
                    IconButton(
                        modifier = Modifier.padding(3.dp),
                        onClick = {
                        }) {
                        Icon(
                            painter = painterResource(id = com.example.composetestproject.R.drawable.notification),
                            contentDescription = "Notification Icon",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )

                    }
                }
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}