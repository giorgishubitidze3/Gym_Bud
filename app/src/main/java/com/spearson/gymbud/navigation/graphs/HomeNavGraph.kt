package com.spearson.gymbud.navigation.graphs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.spearson.gymbud.navigation.BottomBarScreen
import com.spearson.gymbud.presentation.home.HomeScreen
import com.spearson.gymbud.presentation.profile.ProfileScreen
import com.spearson.gymbud.presentation.session.SessionScreen
import com.spearson.gymbud.presentation.workouts.WorkoutsScreen


fun NavGraphBuilder.homeNavGraph(navController: NavHostController, modifier: Modifier = Modifier, logout: () -> Unit){
    navigation(
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None}
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(logout = logout)
        }
        composable(route = BottomBarScreen.Workouts.route) {
            WorkoutsScreen()
        }
        composable(route = BottomBarScreen.Session.route) {
            SessionScreen()
        }
    }
}