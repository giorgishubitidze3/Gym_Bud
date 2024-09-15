package com.spearson.gymbud

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.utils.composable
import com.spearson.gymbud.presentation.home.HomeScreen
import com.spearson.gymbud.presentation.navigation.BottomBar
import com.spearson.gymbud.presentation.navigation.BottomNavigationItem
import com.spearson.gymbud.presentation.navigation.Screens
import com.spearson.gymbud.presentation.profile.ProfileScreen
import com.spearson.gymbud.presentation.session.SessionScreen
import com.spearson.gymbud.presentation.workouts.WorkoutsScreen
import com.spearson.gymbud.ui.theme.GymBudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymBudApp()
        }
    }
}

@Composable
fun GymBudApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screens.Home.route) { HomeScreen() }
            composable(Screens.Session.route) { SessionScreen() }
            composable(Screens.Workouts.route) { WorkoutsScreen() }
            composable(Screens.Profile.route) { ProfileScreen() }
        }
    }
}


