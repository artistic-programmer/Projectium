package com.example.android.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.RootNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = NavRoute.Home.route,
        route = HOME_ROUTE
    ){
//        composable {  }
    }
}