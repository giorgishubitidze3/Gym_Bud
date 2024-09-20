package com.spearson.gymbud.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spearson.gymbud.presentation.home.HomeScreen


@Composable
fun RootNavigationGraph(navController: NavHostController, navBarNavController: NavController, logout: () -> Unit) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)
        composable(route = Graph.HOME) {
            HomeScreen(navController,navBarNavController = navBarNavController,logout = logout)
        }
//        composable(
//            route = Screens.AppScaffold.route,
//            content ={
//                AppScaffold(navController = navBarNavController){
//                    navController.navigate(Screens.Home.route)
//                }
//            }
//        )
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}