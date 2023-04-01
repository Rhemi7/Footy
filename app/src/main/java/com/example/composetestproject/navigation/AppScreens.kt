package com.example.composetestproject.navigation

enum class AppScreens {
    OnboardingScreen,
    LoginScreen,
    SearchScreen,
    HomeScreen,
    StandingsScreen,
    ExploreScreen,
    ProfileScreen,
    ArticleDetailsScreen,
    StandingDetailsScreen,
    MatchDetailsScreen,
    LineUpScreen;


    companion object {
        fun fromRoute(route: String?): AppScreens = when (route?.substringBefore("/")) {
            OnboardingScreen.name -> OnboardingScreen
            SearchScreen.name -> SearchScreen
            HomeScreen.name -> HomeScreen
            StandingsScreen.name -> StandingsScreen
            ExploreScreen.name -> ExploreScreen
            ProfileScreen.name -> ProfileScreen
            ArticleDetailsScreen.name -> ArticleDetailsScreen
            StandingDetailsScreen.name -> StandingDetailsScreen
            MatchDetailsScreen.name -> MatchDetailsScreen
            LoginScreen.name -> LoginScreen
            LineUpScreen.name -> LineUpScreen
            null -> OnboardingScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}