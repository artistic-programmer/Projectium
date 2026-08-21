package com.example.android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android.presentation.component.state.EmptyState
import com.example.android.presentation.component.state.ErrorState
import com.example.android.presentation.component.state.MovieCardSkeleton

@Composable
fun HomeScreen(
    navigateToSearchScreen: () -> Unit,
    navigateToDetailScreen: () -> Unit
){
    Column (
        modifier = Modifier.padding(top = 60.dp).fillMaxSize().background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        val searchState = rememberTextFieldState()
//        HomeSearchBar(
//            textFieldState = searchState,
//            onSearch = { query ->
//                // Later → navigate / call ViewModel / search TMDB
//            }
//        )
//        Text("Home Screen")
//        Button(
//            onClick = navigateToSearchScreen
//        ) {
//            Text("Search")
//        }
//        Button(
//            onClick = navigateToDetailScreen
//        ){
//            Text("Details")
//        }
//
//        MovieCard()
//        Spacer(modifier = Modifier.height(24.dp))
//        MovieCardSkeleton()
//        ErrorState(
//            msg = "We can't load movies...",
//            onRetry = {}
//        )
        EmptyState(
            icon = Icons.Rounded.BookmarkBorder,
            title = "Your watchlist is empty",
            message = "Movies you save will appear here.",
            actionText = "Explore Movies",
            onAction = {
                // Navigate to Home
            }
        )
    }
}