package com.example.android.presentation.component.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ChipSkeleton(){
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .height(22.dp)
            .width(44.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(
                horizontal = 7.dp
            ),
    )
}