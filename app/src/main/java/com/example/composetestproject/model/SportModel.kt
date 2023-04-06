package com.example.composetestproject.model

import com.example.composetestproject.R
import com.example.composetestproject.Sport

data class SportModel(val name: String, val image: Int, val sport: Sport)

val sportList: List<SportModel> = listOf(
    SportModel(name = "Soccer", image = R.drawable.soccer, sport = Sport.Soccer),
    SportModel(name = "Basketball", image = R.drawable.basketball, sport = Sport.Basketball),
    SportModel(name = "Football", image = R.drawable.football, sport = Sport.Football),
    SportModel(name = "Baseball", image = R.drawable.baseball, sport = Sport.Baseball),
    SportModel(name = "Tennis", image = R.drawable.tennis, sport = Sport.Tennis),
    SportModel(name = "Volleyball", image = R.drawable.volly, sport = Sport.Volleyball)

)
