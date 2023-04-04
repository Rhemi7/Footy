package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composetestproject.R
import com.example.composetestproject.Sport
import com.example.composetestproject.navigation.AppScreens

@Preview
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun SplashScreen(navController: NavController = NavController(LocalContext.current)) {
    var sportSelected: MutableState<Sport> = remember {
        mutableStateOf(Sport.Soccer)
    }

    Surface(color = Color(0xff181829),
        modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(top = 50.dp, bottom = 10.dp)) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(
                    text = "Discover all \nabout sport",
                    //                letterSpacing = letterSpacing,
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "You can choose more than one", color = Color(0xff65656B), fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    SportWidget(
                        color = if (sportSelected.value == Sport.Soccer) {
                            Color(0xffEE7A5C)
                        } else Color(0xff222232), image = R.drawable.soccer, name = "Soccer"
                    ) {
                        sportSelected.value = Sport.Soccer

                    }
                    SportWidget(color = if (sportSelected.value == Sport.Basketball) {
                        Color(0xffEE7A5C)
                    } else Color(0xff222232), image = R.drawable.basketball, name = "Basketball") {
                        sportSelected.value = Sport.Basketball
                    }
                    SportWidget(color = if (sportSelected.value == Sport.Football) {
                        Color(0xffEE7A5C)
                    } else Color(0xff222232), image = R.drawable.football, name = "Football") {
                        sportSelected.value = Sport.Football
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    SportWidget(color = if (sportSelected.value == Sport.Baseball) {
                        Color(0xffEE7A5C)
                    } else Color(0xff222232), image = R.drawable.baseball, name = "Baseball") {
                        sportSelected.value = Sport.Baseball
                    }
                    SportWidget(color = if (sportSelected.value == Sport.Tennis) {
                        Color(0xffEE7A5C)
                    } else Color(0xff222232), image = R.drawable.tennis, name = "Tennis") {
                     sportSelected.value = Sport.Tennis
                    }
                    SportWidget(color = if (sportSelected.value == Sport.Volleyball) {
                        Color(0xffEE7A5C)
                    } else Color(0xff222232), image = R.drawable.volly, name = "Volleyball") {
                        sportSelected.value = Sport.Volleyball
                    }
                }
            }
            Spacer(modifier = Modifier.height(150.dp))
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppButton(navController = navController, modifier = Modifier, text = "Continue") {
                    navController.navigate(AppScreens.Dashboard.name)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Skip", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun SportWidget(
    color: Color,
    image: Int,
    name: String,
    onClick: () -> Unit = {}
) {
   Column(
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Surface(
           shape = CircleShape,
           color = color,
           modifier = Modifier
               .size(105.dp)
               .padding(bottom = 5.dp)
               .clickable {
                   onClick.invoke()
               },
       ) {
           Image(
               painter = painterResource(id = image),
               contentDescription = "Football Icon",
               alignment = Alignment.Center,
               modifier = Modifier
                   .size(30.dp)
                   .padding(28.dp)
           )
       }
       Text(text = name, color = Color.White, fontWeight = FontWeight.SemiBold)
   }
}