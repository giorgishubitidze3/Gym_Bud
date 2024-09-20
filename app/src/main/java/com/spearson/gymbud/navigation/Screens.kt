package com.spearson.gymbud.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Session : Screens("session")
    object Workouts : Screens("workouts")
    object Profile : Screens("profile")
    object AppScaffold: Screens("app_scaffold")
}