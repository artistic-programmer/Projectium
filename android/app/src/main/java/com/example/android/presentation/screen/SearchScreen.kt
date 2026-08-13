package com.example.android.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(
    navigateToDetailScreen: () -> Unit
){
    Column(
        modifier = Modifier.padding(top = 30.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search Screen")
        Button(
            onClick = navigateToDetailScreen
        ) {
            Text("Details")
        }
    }
}