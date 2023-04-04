package com.example.composetestproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetestproject.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.OnboardingScreen.name) {
        composable(AppScreens.OnboardingScreen.name) {
            OnboardingScreen(navController = navController)
        }
        composable(AppScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
//        composable(AppScreens.HomeScreen.name) {
//            HomeScreen(navController = navController)
//        }
//        composable(AppScreens.ExploreScreen.name) {
//            ExploreScreen(navController = navController)
//        }
//        composable(AppScreens.StandingsScreen.name) {
//            StandingsScreen(navController = navController)
//        }
//        composable(AppScreens.ProfileScreen.name) {
//            ProfileScreen(navController = navController)
//        }
        composable(AppScreens.Dashboard.name) {
            Dashboard()
        }
    }
}

@Composable
fun DashboardConfigurations(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name) {
        composable(AppScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.ExploreScreen.name) {
            ExploreScreen(navController = navController)
        }
        composable(AppScreens.StandingsScreen.name) {
            StandingsScreen(navController = navController)
        }
        composable(AppScreens.ProfileScreen.name) {
            ProfileScreen(navController = navController)
        }
        composable(AppScreens.Dashboard.name) {
            Dashboard()
        }
    }
}