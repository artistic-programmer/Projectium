package com.example.android.presentation.component.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.Spaces

@Composable
fun MovieCardSkeleton(){
    val cardShape = MaterialTheme.shapes.medium
    Row(
        modifier = Modifier
            .fillMaxWidth(0.96f)
            .height(232.dp)
            .clip(cardShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Poster Image
        Box(
            modifier = Modifier
                .width(130.dp)
                .fillMaxHeight()
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surfaceContainer)
        )

        // Movie Information
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(
                    start = Spaces.md,
                    top = Spaces.sm,
                    end = Spaces.sm
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    // Title Text
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(32.dp)
                            .clip(MaterialTheme.shapes.small)
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                    )
                }
                Spacer(modifier = Modifier.height(Spaces.sm))

                // Chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        Spaces.sm
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    ChipSkeleton()
                    ChipSkeleton()
                    ChipSkeleton()
                }
                Spacer(modifier = Modifier.height(Spaces.sm))

                // Overview
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                )

                Spacer(modifier = Modifier.height(Spaces.sm))

                // Add to watchlist button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                )
            }
        }
    }
}

