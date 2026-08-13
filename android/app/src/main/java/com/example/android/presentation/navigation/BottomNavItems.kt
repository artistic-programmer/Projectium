package com.example.android.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(
    val path: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomNavItems(
        path = NavRoute.Home.route,
        title = "Home",
        icon = Icons.Default.Home
    )
    object Watchlist: BottomNavItems(
        path = NavRoute.Watchlist.route,
        title = "Watchlist",
        icon = Icons.Default.BookmarkAdd
    )
    object Profile: BottomNavItems(
        path = NavRoute.Profile.route,
        title = "Profile",
        icon = Icons.Default.AccountCircle
    )
}