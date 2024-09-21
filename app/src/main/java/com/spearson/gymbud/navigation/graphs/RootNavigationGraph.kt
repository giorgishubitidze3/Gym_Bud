package com.spearson.gymbud.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spearson.gymbud.presentation.home.HomeScreen


@Composable
fun RootNavigationGraph(navController: NavHostController, logout: () -> Unit, modifier:Modifier) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController,
            onLoginSuccess = {
                navController.popBackStack()
                navController.navigate(Graph.HOME)
            })

        homeNavGraph(navController, modifier = modifier ,logout)

    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}