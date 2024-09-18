package com.spearson.gymbud.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationIte(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
