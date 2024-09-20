package com.spearson.gymbud.presentation.home


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.spearson.gymbud.navigation.graphs.HomeNavGraph
import com.spearson.gymbud.presentation.bottombar.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(mainNavController: NavHostController, navBarNavController: NavController, logout: () -> Unit) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navBarNavController)
        }
    ) {
        HomeNavGraph(navController = mainNavController, navBarNavController= navBarNavController){
            logout()
        }
    }

}
