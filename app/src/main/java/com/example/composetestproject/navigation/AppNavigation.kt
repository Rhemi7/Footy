package com.example.composetestproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetestproject.screens.OnboardingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.OnboardingScreen.name) {
        composable(AppScreens.OnboardingScreen.name) {
            OnboardingScreen(navController = navController)
        }
    }
}