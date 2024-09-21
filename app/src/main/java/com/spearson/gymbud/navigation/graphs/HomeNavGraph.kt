package com.spearson.gymbud.navigation.graphs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.spearson.gymbud.domain.model.GymExercise
import com.spearson.gymbud.navigation.BottomBarScreen
import com.spearson.gymbud.navigation.Screens
import com.spearson.gymbud.presentation.main.home.HomeScreen
import com.spearson.gymbud.presentation.main.profile.ProfileScreen
import com.spearson.gymbud.presentation.main.session.SessionScreen
import com.spearson.gymbud.presentation.main.workouts.WorkoutsScreen
import com.spearson.gymbud.presentation.main.workouts.workouts_detail.WorkoutDetailScreen
import kotlinx.serialization.json.Json


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
            WorkoutsScreen(navController)
        }
        composable(route = BottomBarScreen.Session.route) {
            SessionScreen()
        }
        composable(
            route = "${Screens.WorkoutDetails.route}/{workout}",
            arguments = listOf(navArgument("workout"){type = NavType.StringType})
        ){backStackEntry ->
            val workoutJson = backStackEntry.arguments?.getString("workout")
            val workout = workoutJson?.let{ Json.decodeFromString<GymExercise>(it)}
            workout?.let{
                WorkoutDetailScreen(exercise = it)
            }
        }
    }
}