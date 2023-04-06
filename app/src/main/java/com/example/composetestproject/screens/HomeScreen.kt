package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetestproject.R
import com.example.composetestproject.Sport
import com.example.composetestproject.components.LeagueCountryComponent
import com.example.composetestproject.components.ScoreCardComponent
import com.example.composetestproject.components.SportRectangularCard
import com.example.composetestproject.components.SportyAppBar
import com.example.composetestproject.model.SportModel
import com.example.composetestproject.model.sportList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    var sportSelected: MutableState<Sport> = remember {
        mutableStateOf(Sport.Soccer)
    }

    Scaffold(
        backgroundColor = Color(0xff181829),
        topBar = {
            SportyAppBar(title = "LiveScore", navController = navController)
        }
    ) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 80.dp)) {

            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            LazyRow(modifier = Modifier.padding(start = 10.dp, top = 30.dp, bottom = 10.dp)) {

                items(items = sportList) {item ->

                    SportRectangularCard(item, color = if (sportSelected.value == item.sport) {R.color.select_sport_color} else {R.color.sub_background}) {
                        sportSelected.value = item.sport
                    }
                }
            }
//            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(10.dp)) {
                LeagueCountryComponent(flag = R.drawable.spain, country = "Spain", league = "La Liga")
                ScoreCardComponent(
                    fTeamImage = R.drawable.barcelona,
                    sTeamImage = R.drawable.realmadrid,
                    fTeamName = "Barcelona",
                    sTeamName = "Real Madrid",
                    fTeamScore = "2",
                    secTeamScore = "0",
                    dur = "HT"
                )
                LeagueCountryComponent(flag = R.drawable.england, country = "England", league = "Premier League")
                ScoreCardComponent(
                    fTeamImage = R.drawable.astonvilla,
                    sTeamImage = R.drawable.liverpool,
                    fTeamName = "Aston Villa",
                    sTeamName = "Liverpool",
                    fTeamScore = "2",
                    secTeamScore = "3",
                    dur = "FT"
                )
                ScoreCardComponent(
                    fTeamImage = R.drawable.astonvilla,
                    sTeamImage = R.drawable.liverpool,
                    fTeamName = "Aston Villa",
                    sTeamName = "Liverpool",
                    fTeamScore = "2",
                    secTeamScore = "3",
                    dur = "FT"
                )
            }
        }
    }
}

