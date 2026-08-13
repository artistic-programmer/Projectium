package com.example.android.presentation.navigation

import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(
    navController: NavController
){
    val navItems = listOf(
        BottomNavItems.Home,
        BottomNavItems.Watchlist,
        BottomNavItems.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Log.d("BtwBottomNav", "Current Route = $currentRoute")

    NavigationBar {
        navItems.forEachIndexed { index, items ->
            NavigationBarItem(
                selected = currentRoute?.startsWith(items.path) == true,
                onClick = {
                    val route = when(items){
                        BottomNavItems.Home -> NavRoute.Home.route
                        BottomNavItems.Watchlist -> NavRoute.Watchlist.route
                        BottomNavItems.Profile -> NavRoute.Profile.route
                    }
                    navController.navigate(route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = items.icon,
                        contentDescription = items.title
                    )
                },
                label = {
                    Text(text = items.title)
                }
            )
        }
    }
}