package com.spearson.gymbud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spearson.gymbud.presentation.graphs.Graph
import com.spearson.gymbud.presentation.graphs.RootNavigationGraph
import com.spearson.gymbud.presentation.home.HomeScreen
import com.spearson.gymbud.presentation.navigation.BottomBar
import com.spearson.gymbud.presentation.navigation.Screens
import com.spearson.gymbud.presentation.profile.ProfileScreen
import com.spearson.gymbud.presentation.session.SessionScreen
import com.spearson.gymbud.presentation.workouts.WorkoutsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Graph.ROOT
            ) {
                composable(route = Graph.ROOT) {
                    RootNavigationGraph(navController = navController)
                }
            }//            GymBudApp()
        }
    }
}

//@Composable
//fun GymBudApp() {
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            BottomBar(navController = navController)
//        }
//    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = Screens.Home.route,
//            Modifier.padding(innerPadding)
//        ) {
//            composable(Screens.Home.route) { HomeScreen() }
//            composable(Screens.Session.route) { SessionScreen() }
//            composable(Screens.Workouts.route) { WorkoutsScreen() }
//            composable(Screens.Profile.route) { ProfileScreen() }
//        }
//    }
//}


