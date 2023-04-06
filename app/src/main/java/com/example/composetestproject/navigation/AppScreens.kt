package com.example.composetestproject.navigation

enum class AppScreens {
    OnboardingScreen,
    SplashScreen,
    SearchScreen,
    HomeScreen,
    StandingsScreen,
    ExploreScreen,
    ProfileScreen,
    ArticleDetailsScreen,
    StandingDetailsScreen,
    MatchDetailsScreen,
    LineUpScreen,
    Dashboard,
    HomeHost;


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
            SplashScreen.name -> SplashScreen
            LineUpScreen.name -> LineUpScreen
            Dashboard.name -> Dashboard
            HomeHost.name -> HomeHost
            null -> OnboardingScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}