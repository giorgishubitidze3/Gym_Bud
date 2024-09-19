package com.spearson.gymbud.presentation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spearson.gymbud.presentation.home.HomeScreen
import com.spearson.gymbud.presentation.navigation.BottomBarScreen
import com.spearson.gymbud.presentation.profile.ProfileScreen
import com.spearson.gymbud.presentation.session.SessionScreen
import com.spearson.gymbud.presentation.workouts.WorkoutsScreen

@Composable
fun HomeNavGraph(navController: NavHostController,modifier: Modifier = Modifier,bottomBarNavController: NavController){
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route,
        modifier = modifier
    ){
        composable(route= BottomBarScreen.Home.route){
            HomeScreen(bottomBarNavController=bottomBarNavController)
        }

        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }

        composable(route = BottomBarScreen.Workouts.route){
            WorkoutsScreen()
        }

        composable(route = BottomBarScreen.Session.route){
            SessionScreen()
        }

    }
}