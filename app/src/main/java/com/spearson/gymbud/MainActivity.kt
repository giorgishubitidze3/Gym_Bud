package com.spearson.gymbud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spearson.gymbud.navigation.Screens
import com.spearson.gymbud.presentation.home.HomeScreen
import com.spearson.gymbud.navigation.graphs.Graph
import com.spearson.gymbud.navigation.graphs.RootNavigationGraph
import com.spearson.gymbud.navigation.graphs.authNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bottomBarNavController = rememberNavController()
            RootNavigationGraph(navController = rememberNavController(),bottomBarNavController) {
                print(
                    "helloWorld"
                )
            }
        }
    }
}




