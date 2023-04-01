package com.example.composetestproject.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun OnboardingScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xff181829)) {
        Text("Onboarding")
    }
}