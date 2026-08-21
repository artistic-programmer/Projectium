package com.example.android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android.data.model.FakeMovieResponse
import com.example.android.data.model.FakeMovieResponse2
import com.example.android.data.model.FakeMovieResponse3
import com.example.android.data.model.MovieModel
import com.example.android.presentation.component.HomeSearchBar
import com.example.android.presentation.component.MovieList
import com.example.android.presentation.component.StatusBarPadding
import com.example.android.presentation.component.categories.MovieCategory
import com.example.android.presentation.component.categories.MovieCategorySelector
import com.example.android.presentation.component.state.EmptyState
import com.example.android.presentation.component.state.ErrorState
import com.example.android.presentation.component.state.MovieCardSkeleton
import com.example.android.ui.theme.Constants
import com.example.android.ui.theme.Spaces

@Composable
fun HomeScreen(
    navigateToSearchScreen: () -> Unit,
    navigateToDetailScreen: () -> Unit
){
    val searchState = rememberTextFieldState()

    val FakePopularMovies = listOf(
        FakeMovieResponse,
        FakeMovieResponse,
        FakeMovieResponse,
        FakeMovieResponse,
        FakeMovieResponse,
    )
    var selectedCategory by remember {
        mutableStateOf(MovieCategory.POPULAR)
    }

    val FakeTopRatedMovies = listOf(
        FakeMovieResponse2,
        FakeMovieResponse2,
        FakeMovieResponse2
    )

    val FakeUpcomingMovies = listOf(
        FakeMovieResponse3,
        FakeMovieResponse3,
        FakeMovieResponse3
    )
    val movies = when (selectedCategory) {
        MovieCategory.POPULAR -> FakePopularMovies
        MovieCategory.TOP_RATED -> FakeTopRatedMovies
        MovieCategory.UPCOMING -> FakeUpcomingMovies
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(Spaces.sm))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Spaces.lg
                )
        ){
            Text(
                text = Constants.APP_NAME,
                style = MaterialTheme.typography.displayLarge
            )
        }
        Spacer(modifier = Modifier.height(Spaces.xs))
        HomeSearchBar(
            textFieldState = searchState,
            onSearch = { navigateToSearchScreen() }
        )
        Spacer(modifier = Modifier.height(Spaces.md))
        // Navigation Tab Between Popular,  Top Rated and Upcoming
        // Categories
        MovieCategorySelector(
            selectedCategory = selectedCategory,
            onCategorySelected = {
                selectedCategory = it
            }
        )

        Spacer(
            modifier = Modifier.height(Spaces.md)
        )
        MovieList(
            movies = movies,
            onMovieClick = {
                navigateToDetailScreen()
            }
        )
    }
}