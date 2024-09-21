package com.spearson.gymbud.presentation.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.spearson.gymbud.navigation.BottomBarScreen

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Session,
        BottomBarScreen.Workouts,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = items.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        val selectedRoute = currentDestination?.route

        NavigationBar {
            items.forEach { screen ->
                val isSelected = screen.route == selectedRoute
                NavigationBarItem(
                    selected = isSelected,

                    label = {
                        Text(text = screen.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if(isSelected) screen.selectedIcon else screen.unselectedIcon,
                            contentDescription = "Navigation Icon"
                        )
                    },
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    }
                )

            }
        }
    }
}
