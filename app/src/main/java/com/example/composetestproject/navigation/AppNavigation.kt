package com.example.composetestproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetestproject.screens.OnboardingScreen
import com.example.composetestproject.screens.SplashScreen

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
    }
}