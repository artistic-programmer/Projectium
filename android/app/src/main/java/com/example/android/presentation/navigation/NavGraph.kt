package com.example.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android.presentation.screen.HomeScreen
import com.example.android.presentation.screen.ProfileScreen
import com.example.android.presentation.screen.WatchlistScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE,
        modifier = modifier
    ){
        HomeNavGraph(navController)
        composable(NavRoute.Watchlist.route){
            WatchlistScreen()
        }
        composable(NavRoute.Profile.route) {
            ProfileScreen()
        }

    }
}
