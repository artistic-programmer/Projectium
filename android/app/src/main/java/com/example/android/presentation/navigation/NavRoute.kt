package com.example.android.presentation.navigation

const val ROOT_ROUTE = "root_route"
const val HOME_ROUTE = "home_route"

sealed class NavRoute(val route: String) {
    object Home: NavRoute("home_screen")
    object Watchlist: NavRoute("watchlist_screen")
    object Profile: NavRoute("account_screen")
    object Search: NavRoute("search_screen")
    object Detail: NavRoute("detail_screen")
}