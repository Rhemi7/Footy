package com.example.composetestproject.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetestproject.navigation.AppNavigation
import com.example.composetestproject.navigation.BottomNavBar
import com.example.composetestproject.navigation.DashboardConfigurations

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Dashboard() {
        val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavBar(navController = navController)
    }) {
//        HomeScreen(navController = navController)
//        ExploreScreen(navController = navController)
        DashboardConfigurations(navController = navController)
    }
}