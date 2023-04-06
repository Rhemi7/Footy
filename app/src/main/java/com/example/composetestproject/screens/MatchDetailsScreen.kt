package com.example.composetestproject.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composetestproject.R
import com.example.composetestproject.components.SportyAppBar
import com.example.composetestproject.components.TeamIcon

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MatchDetailsScreen(navController: NavHostController) {
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
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            BigTeamWidget(image = R.drawable.arsenal, name = "Arsenal")
            ScoreWidget(fTeamScore = "2", secTeamScore = "3")
            BigTeamWidget(image = R.drawable.astonvilla, name = "Aston Villa")

        }
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
        TeamIcon(R.drawable.arsenal, size = 70, padding = 15)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Arsenal", color = Color.White)
    }
}