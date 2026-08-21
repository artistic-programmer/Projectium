package com.example.android.presentation.component.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.android.ui.theme.Spaces

@Composable
fun CategoryChip(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(shapes.small)
            .background(
                if (selected)
                    MaterialTheme.colorScheme.primary
                else
                    Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = Spaces.sm,
                vertical = Spaces.xs
            )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}