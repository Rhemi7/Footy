package com.example.composetestproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val localDims = LocalContext.current.resources.displayMetrics
    var letterSpacing by remember { mutableStateOf(0.4.sp) }
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    val email = rememberSaveable {
        mutableStateOf("")
    }

    var loading: Boolean = false

    val password = rememberSaveable {
        mutableStateOf("")
    }

    val passwordVisibility = rememberSaveable {
        mutableStateOf(false)
    }

    val passwordFocusRequest = FocusRequester.Default

    val valid = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetBackgroundColor = Color(0xff222232),
        sheetContent = {
            Column(
               horizontalAlignment = Alignment.Start,

                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxHeight(0.57f)
            ) {
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Welcome",
//                letterSpacing = letterSpacing,
                    style = MaterialTheme.typography.h5.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                EmailInput(
                    emailState = email,
                    enabled = !loading,
                    leadingIcon = painterResource(id = R.drawable.message),
                    onAction = KeyboardActions {
//                        passwordFocusRequest.requestFocus()
                    })
                PasswordInput(
                    modifier = Modifier.focusRequester(passwordFocusRequest),
                    passwordState = password,
                    labelId = "Password",
                    enabled = !loading,
                    passwordVisibility = passwordVisibility,
                    leadingIcon= painterResource(id = R.drawable.password),
                    onAction = KeyboardActions {

                        if (!valid) return@KeyboardActions
//                        onDone(email.value.trim(), password.value.trim())
                    }) {

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(uncheckedColor = Color(0xff65656B))
                        )
                        Text(text = "Remember me", color = Color(0xff65656B))
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Forgot Password", color = Color.White)
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff246BFD)),
                    onClick = {
                        coroutineScope.launch { modalSheetState.hide() }
                    }
                ) {
                    Text(text = "Sign in", color = Color.White)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Don't have an account?", color = Color.White)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Sign Up", color = Color(0xff246BFD))
                    }
                }
            }
        }
    ) {

        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xff181829)) {
            Column(modifier = Modifier.padding(40.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.mbappe),
                    contentDescription = "Mbappe Image",
                    modifier = Modifier.size(400.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Discover all \nabout sport",
//                letterSpacing = letterSpacing,
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Search millions of jobs and get the\ninside scoop on companies.\n" +
                            "Wait for what? Let’s get start it!",
                    letterSpacing = letterSpacing,
                    style = TextStyle(color = Color.Gray, fontSize = 15.sp)
                )
                Spacer(modifier = Modifier.height(35.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .clip(RoundedCornerShape(15.dp))
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff246BFD)),
                        onClick = {
                            coroutineScope.launch {
                                modalSheetState.animateTo(ModalBottomSheetValue.Expanded)

                            }
                        }) {
                        Text(text = "Sign in", style = TextStyle(fontSize = 18.sp, color = Color.White))
                    }
                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = "Sign Up", color = Color.Gray, fontSize = 18.sp)
                    }
                }

            }
        }

//        Scaffold {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentAlignment = Alignment.Center,
//            ) {
//                Button(
//                    onClick = {
//                        coroutineScope.launch {
//                            if (modalSheetState.isVisible)
//                                modalSheetState.hide()
//                            else
//                                modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
//                        }
//                    },
//                ) {
//                    Text(text = "Open Sheet")
//                }
//            }
//        }
    }

}

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