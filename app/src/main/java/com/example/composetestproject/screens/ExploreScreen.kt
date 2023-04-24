package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.R
import com.example.composetestproject.navigation.AppScreens

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun ExploreScreen(navController: NavController) {
    Scaffold(backgroundColor = Color(0xff181829)) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, bottom = 80.dp, top = 50.dp)) {

            SearchWidget(navController)

        }
    }
}

@Composable
fun SearchWidget(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController.navigate(AppScreens.SearchScreen.name)
            },
        color = Color(0xff222232)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 15.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                tint = Color(0xff65656B),
                modifier = Modifier
                    .size(25.dp)
                    .padding(3.dp)
            )


            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "Search for news, team, match, etc...",
                color = Color(0xff65656B),
                fontSize = 16.sp
            )
        }
    }
}