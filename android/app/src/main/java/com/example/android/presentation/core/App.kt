package com.example.android.presentation.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.android.presentation.navigation.BottomNavBar
import com.example.android.presentation.navigation.NavGraph

@Composable
fun App(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )

    }
}