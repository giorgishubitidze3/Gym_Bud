package com.spearson.gymbud

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spearson.gymbud.navigation.Screens
import com.spearson.gymbud.presentation.main.home.HomeScreen
import com.spearson.gymbud.navigation.graphs.Graph

import com.spearson.gymbud.navigation.graphs.RootNavigationGraph
import com.spearson.gymbud.navigation.graphs.authNavGraph
import com.spearson.gymbud.presentation.bottombar.BottomBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                GymBudApp()
            }
        }
    }




@Composable
fun GymBudApp(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ){innerPadding ->
        RootNavigationGraph(navController = navController,{print("hello")} , modifier = Modifier.padding(innerPadding))
    }


}



