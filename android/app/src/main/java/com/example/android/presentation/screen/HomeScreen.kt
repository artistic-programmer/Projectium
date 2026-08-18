package com.example.android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android.presentation.component.MovieCard

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
        Text("Home Screen")
        Button(
            onClick = navigateToSearchScreen
        ) {
            Text("Search")
        }
        Button(
            onClick = navigateToDetailScreen
        ){
            Text("Details")
        }

        MovieCard()
    }
}