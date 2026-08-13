package com.example.android.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.android.presentation.screen.DetailScreen
import com.example.android.presentation.screen.HomeScreen
import com.example.android.presentation.screen.SearchScreen


fun NavGraphBuilder.HomeNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = NavRoute.Home.route,
        route = HOME_ROUTE
    ){
        composable(
            route = NavRoute.Home.route
        ) {
            HomeScreen(
                navigateToSearchScreen = {
                    navController.navigate(NavRoute.Search.route){
                        launchSingleTop = true
                    }
                },
                navigateToDetailScreen = {
                    navController.navigate(NavRoute.Detail.route){
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = NavRoute.Search.route
        ) {
            SearchScreen(
                navigateToDetailScreen = {
                    navController.navigate(NavRoute.Detail.route){
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = NavRoute.Detail.route
        ){
            DetailScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}