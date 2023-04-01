package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import kotlinx.coroutines.coroutineScope
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

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),


        sheetContent = {
            Column(
                //...
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch { modalSheetState.hide() }
                    }
                ) {
                    Text(text = "Hide Sheet")
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
