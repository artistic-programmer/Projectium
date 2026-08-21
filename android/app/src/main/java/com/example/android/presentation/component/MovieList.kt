package com.example.android.presentation.component

import android.graphics.Movie
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.LinkAnnotation
import com.example.android.data.model.MovieModel

@Composable
fun MovieList(
    movies: List<MovieModel>,
    onMovieClick: () -> Unit
){
    LazyColumn {
        items(movies){
            movie -> MovieCard(movie, onClick = onMovieClick)
        }
    }
}