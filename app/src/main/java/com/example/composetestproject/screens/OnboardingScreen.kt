package com.example.composetestproject.screens

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.R
import com.example.composetestproject.components.EmailInput
import com.example.composetestproject.components.PasswordInput
import com.example.composetestproject.navigation.AppScreens
import kotlinx.coroutines.CoroutineScope
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
                        passwordFocusRequest.requestFocus()
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
                AppButton(navController, modifier = Modifier, text = "Sign in") {
                    navController.navigate(AppScreens.SplashScreen.name)
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

        MainSplash(
            letterSpacing = letterSpacing,
            coroutineScope = coroutineScope,
            modalSheetState = modalSheetState,
            navController = navController
        )

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
 fun AppButton(navController: NavController, modifier: Modifier, text: String, onClick: ()-> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(15.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff246BFD)),
        onClick = {
//                        coroutineScope.launch { modalSheetState.hide() }
//
            onClick.invoke()
        }
    ) {
        Text(text = text, color = Color.White, fontSize = 18.sp)
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun MainSplash(
    navController: NavController,
    letterSpacing: TextUnit,
    coroutineScope: CoroutineScope,
    modalSheetState: ModalBottomSheetState
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xff181829)
    ) {
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
                AppButton(navController = navController, modifier = Modifier.fillMaxWidth(0.6f), text = "Sign in") {
                    coroutineScope.launch {
                        modalSheetState.animateTo(ModalBottomSheetValue.Expanded)

                    }
                }
//                Button(
//                    modifier = Modifier
//                        .fillMaxWidth(0.6f)
//                        .clip(RoundedCornerShape(15.dp))
//                        .height(60.dp),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff246BFD)),
//                    onClick = {
//                        coroutineScope.launch {
//                            modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
//
//                        }
//                    }) {
//                    Text(
//                        text = "Sign in",
//                        style = TextStyle(fontSize = 18.sp, color = Color.White)
//                    )
//                }
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(text = "Sign Up", color = Color.Gray, fontSize = 18.sp)
                }
            }

        }
    }
}
