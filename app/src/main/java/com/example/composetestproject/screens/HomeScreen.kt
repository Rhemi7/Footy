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

@Composable
fun ScoreCardComponent(fTeamImage: Int, sTeamImage: Int, fTeamName: String, sTeamName: String, fTeamScore: String, secTeamScore: String, dur: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Column() {
            Surface(
                color = colorResource(id = R.color.score_card_color), modifier = Modifier
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
                id = R.color.sub_background
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
private fun TeamIcon(team: Int) {
    Surface(
        modifier = Modifier.size(38.dp), shape = CircleShape, color = colorResource(
            id = R.color.sub_background
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
private fun SportRectangularCard(item: SportModel, color: Int, onClick: ()-> Unit) {
    Surface(modifier = Modifier
        .width(152.dp)
        .height(142.dp)
        .padding(end = 20.dp)
        .clickable { onClick.invoke() },
        shape = RoundedCornerShape(15.dp),
        color = colorResource(
            id = color
        )) {
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
                            painter = painterResource(id = R.drawable.search),
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
                            painter = painterResource(id = R.drawable.notification),
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