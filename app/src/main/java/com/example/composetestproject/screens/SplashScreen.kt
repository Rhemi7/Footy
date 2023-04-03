package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Preview
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SplashScreen(navController: NavController = NavController(LocalContext.current)) {
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
                    SportWidget(color = Color(0xff222232), image = R.drawable.soccer, name = "Soccer")
                    SportWidget(color = Color(0xff222232), image = R.drawable.basketball, name = "Basketball")
                    SportWidget(color = Color(0xff222232), image = R.drawable.football, name = "Football")
                }
                Spacer(modifier = Modifier.height(25.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    SportWidget(color = Color(0xff222232), image = R.drawable.baseball, name = "Baseball")
                    SportWidget(color = Color(0xff222232), image = R.drawable.tennis, name = "Tennis")
                    SportWidget(color = Color(0xff222232), image = R.drawable.volly, name = "Volleyball")
                }
            }
        }
    }
}

@Composable
fun SportWidget(
    color: Color,
    image: Int,
    name: String
) {
   Column(
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Surface(
           color = color,
           modifier = Modifier.size(105.dp)
               .padding(bottom = 5.dp),
           shape = CircleShape
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