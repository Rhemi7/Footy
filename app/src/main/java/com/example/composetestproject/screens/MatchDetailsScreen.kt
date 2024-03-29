package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composetestproject.MatchInfo
import com.example.composetestproject.R
import com.example.composetestproject.Team
import com.example.composetestproject.components.ScoreCardComponent
import com.example.composetestproject.components.SportyAppBar
import com.example.composetestproject.components.TeamIcon
import com.example.composetestproject.navigation.AppScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MatchDetailsScreen(navController: NavHostController) {
    val infoSelected: MutableState<MatchInfo> = remember {
        mutableStateOf(MatchInfo.MatchDetails)
    }

    Scaffold(
        topBar = {
            SportyAppBar(
                title = "UEFA Champions League",
                navController = navController,
                icon = Icons.Default.KeyboardArrowLeft
            ) {
                navController.popBackStack()
            }
        }, backgroundColor = colorResource(
            id = R.color.background
        )
    ) {
        Column() {
            ScoreWidget()
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                        .fillMaxWidth()
                ) {
                    MatchDetailsIndicator("Match Detail", color = if (infoSelected.value == MatchInfo.MatchDetails) {
                        colorResource(id = R.color.select_sport_color)} else {Color.Transparent}) {
                        infoSelected.value = MatchInfo.MatchDetails
                    }
                    MatchDetailsIndicator("Line Up", color = if (infoSelected.value == MatchInfo.LineUp) {
                        colorResource(id = R.color.select_sport_color)} else {Color.Transparent}) {
                        infoSelected.value = MatchInfo.LineUp
                    }
                    MatchDetailsIndicator("H2H", color = if (infoSelected.value == MatchInfo.H2H) {
                        colorResource(id = R.color.select_sport_color)} else {Color.Transparent}) {
                        infoSelected.value = MatchInfo.H2H
                    }

                }

                when (infoSelected.value) {
                    MatchInfo.MatchDetails -> {
                        MatchDetailsSection(navController)
                    }
                    MatchInfo.LineUp -> {
                        LineUpSection(navController)
                    }
                    else -> {
                        Box{}
                    }
                }
            } 
        }
        
    }
}

@Composable
fun LineUpSection(navController: NavHostController) {
    val teamSelected: MutableState<Team> = remember {
        mutableStateOf(Team.Home)
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Formation", fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "(4-2-3-1)", color = colorResource(id = R.color.text_color))
        }
       Row(modifier = Modifier.padding(vertical = 20.dp)) {
           MatchDetailsIndicator(
               "Arsenal",
               height = 30.dp,
               width = 100.dp,
               color = if (teamSelected.value == Team.Home) {
                   colorResource(id = R.color.select_sport_color)
               } else {
                   Color.Transparent
               }
           ) {
               teamSelected.value = Team.Home
           }
           MatchDetailsIndicator(
               "Aston Villa",
               height = 33.dp,
               width = 100.dp,
               color = if (teamSelected.value == Team.Away) {
                   colorResource(id = R.color.select_sport_color)
               } else {
                   Color.Transparent
               }
           ) {
               teamSelected.value = Team.Away
           }
       }
        Image(
            painter = painterResource(id = R.drawable.fieldfootball),
            contentDescription = "Team Line Up",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun MatchDetailsSection(navController: NavHostController) {
    Column(modifier = Modifier.padding(vertical = 20.dp)) {
        MatchDetailsTile(data1 = "8", data2 = "12", name = "Shooting")
        MatchDetailsTile(data1 = "22", data2 = "29", name = "Attacks")
        MatchDetailsTile(data1 = "42", data2 = "58", name = "Possession")
        MatchDetailsTile(data1 = "3", data2 = "5", name = "Cards")
        MatchDetailsTile(data1 = "8", data2 = "7", name = "Corners")
    }

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Other Match",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(text = "See all", color = Color(0xffC4C4C4), fontSize = 14.sp)
        }
        ScoreCardComponent(
            fTeamImage = R.drawable.astonvilla,
            sTeamImage = R.drawable.liverpool,
            fTeamName = "Aston Villa",
            sTeamName = "Liverpool",
            fTeamScore = "2",
            secTeamScore = "3",
            dur = "FT"
        ) {
            navController.navigate(AppScreens.MatchDetailsScreen.name)
        }
        ScoreCardComponent(
            fTeamImage = R.drawable.astonvilla,
            sTeamImage = R.drawable.liverpool,
            fTeamName = "Aston Villa",
            sTeamName = "Liverpool",
            fTeamScore = "2",
            secTeamScore = "3",
            dur = "FT"
        ) {
            navController.navigate(AppScreens.MatchDetailsScreen.name)
        }
        ScoreCardComponent(
            fTeamImage = R.drawable.astonvilla,
            sTeamImage = R.drawable.liverpool,
            fTeamName = "Aston Villa",
            sTeamName = "Liverpool",
            fTeamScore = "2",
            secTeamScore = "3",
            dur = "FT"
        ) {
            navController.navigate(AppScreens.MatchDetailsScreen.name)
        }
    }
}

@Composable
fun MatchDetailsTile( data1: String, data2: String, name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = data1, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Text(
            text = name,
            color = Color(0xffC4C4C4),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(text = data2, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun MatchDetailsIndicator(name: String, color: Color, height: Dp = 50.dp,  width: Dp = 130.dp, onTap: ()-> Unit) {
    Surface(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(
                RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp,
                    bottomEnd = 25.dp,
                    bottomStart = 25.dp
                )
            )
            .clickable { onTap.invoke() },
        color = color
//        Color.Transparent
//        colorResource(
//            id = R.color.select_sport_color
//        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Composable
fun ScoreWidget() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BigTeamWidget(image = R.drawable.arsenal, name = "Arsenal")
        ScoreWidget(fTeamScore = "2", secTeamScore = "3")
        BigTeamWidget(image = R.drawable.astonvilla, name = "Aston Villa")

    }
}

@Composable
fun ScoreWidget(fTeamScore: String, secTeamScore: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = fTeamScore,
                style = MaterialTheme.typography.h3.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "-",
                style = MaterialTheme.typography.h3.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = secTeamScore,
                style = MaterialTheme.typography.h3.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "90.15", color = Color.White)
    }
}

@Composable
fun BigTeamWidget(image: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TeamIcon(image, size = 70, padding = 15)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name, color = Color.White)
    }
}