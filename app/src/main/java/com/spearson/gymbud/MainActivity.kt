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
import com.spearson.gymbud.presentation.navigation.graphs.Graph
import com.spearson.gymbud.presentation.navigation.graphs.RootNavigationGraph
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
            val bottomBarNavController = rememberNavController()
            RootNavigationGraph(navController = rememberNavController(),bottomBarNavController)
        }
    }
}



