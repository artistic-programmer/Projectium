package com.example.android.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.classicBlack70
import com.example.android.ui.theme.ratingYellow

@Composable
fun GenreChip(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(18.dp)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .border(
                width = 0.5.dp,
                color = classicBlack70,
                shape = MaterialTheme.shapes.small
            )
            .padding(
                horizontal = 3.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}