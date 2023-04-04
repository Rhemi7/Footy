package com.example.composetestproject.navigation

import com.example.composetestproject.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.home, AppScreens.HomeScreen.name)
    object Explore: BottomNavItem("Explore", R.drawable.discovery, AppScreens.ExploreScreen.name)
    object Standings: BottomNavItem("Standings", R.drawable.chart, AppScreens.StandingsScreen.name)
    object Profile: BottomNavItem("Profile", R.drawable.profile, AppScreens.ProfileScreen.name)
}