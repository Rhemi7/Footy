package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.R
import com.example.composetestproject.Sport
import com.example.composetestproject.components.SportRectangularCard
import com.example.composetestproject.model.SportModel
import com.example.composetestproject.model.sportList
import com.example.composetestproject.navigation.AppScreens

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun ExploreScreen(navController: NavController) {
    var sportSelected: MutableState<Sport> = remember {
        mutableStateOf(Sport.Soccer)
    }

    Scaffold(backgroundColor = Color(0xff181829)) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, bottom = 80.dp, top = 50.dp)) {

            SearchWidget(navController)

            LazyRow(modifier = Modifier.padding(start = 10.dp, top = 30.dp, bottom = 10.dp)) {

                items(items = sportList) { item ->

                    if (sportSelected.value == item.sport) {
                        HorizontalSportsCard(item) {

                        }
                    } else {
                        CircularSportWidget(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            Color(0xff222232),
                            item.image,
                            circleSize = 80.dp,
                            iconSize = 40.dp,
                            iconPadding = 17.dp
                        ) {
                            sportSelected.value = item.sport
                        }
                    }
                    }
                }
            }
        }
    }

@Composable
fun HorizontalSportsCard(item: SportModel, onClick: ()-> Unit) {
    Surface(
        modifier = Modifier.padding(horizontal = 10.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp
                )
            )
            .clickable { onClick.invoke() }, color = colorResource(id = R.color.select_sport_color)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Sport Icon",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
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