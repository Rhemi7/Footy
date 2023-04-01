package com.example.composetestproject.screens

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

@Composable
fun OnboardingScreen(navController: NavController) {
    val localDims = LocalContext.current.resources.displayMetrics
    var letterSpacing by remember { mutableStateOf(0.4.sp) }

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
                    onClick = { /*TODO*/ }) {
                    Text(text = "Sign in", style = TextStyle(fontSize = 18.sp, color = Color.White))
                }
                TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 20.dp)) {
                    Text(text = "Sign Up", color = Color.Gray, fontSize = 18.sp)
                }
            }

        }
    }
}