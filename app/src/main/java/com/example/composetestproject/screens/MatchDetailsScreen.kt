package com.example.composetestproject.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composetestproject.MatchInfo
import com.example.composetestproject.R
import com.example.composetestproject.Sport
import com.example.composetestproject.components.SportyAppBar
import com.example.composetestproject.components.TeamIcon

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MatchDetailsScreen(navController: NavHostController) {
    var infoSelected: MutableState<MatchInfo> = remember {
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
            Column() {
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

//                    Text(text = "Line Up", color = Color.White, modifier = Modifier.padding(5.dp))
//                    Text(text = "Line Up", color = Color.White, modifier = Modifier.padding(5.dp))
                }
            } 
        }
        
    }
}

@Composable
fun MatchDetailsIndicator(name: String, color: Color, onTap: ()-> Unit) {
    Surface(
        modifier = Modifier
            .width(130.dp)
            .height(50.dp)
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