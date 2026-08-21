package com.example.android.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StatusBarPadding(){
    Box(
        modifier = Modifier.border(1.dp, Color.Red)
            .background(MaterialTheme.colorScheme.background)
            .padding(
                top = WindowInsets
                    .statusBars
                    .asPaddingValues()
                    .calculateTopPadding() + 5.dp
            )
            .fillMaxWidth()

    )
}