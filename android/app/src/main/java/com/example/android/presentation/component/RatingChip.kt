package com.example.android.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.ui.theme.classicBlack70
import com.example.android.ui.theme.ratingYellow


@Composable
fun RatingChip(
    rating: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(22.dp)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .border(
                width = 0.5.dp,
                color = ratingYellow,
                shape = MaterialTheme.shapes.small
            )
            .padding(
                horizontal = 6.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier.size(13.dp),
            tint = ratingYellow
        )

        Text(
            text = String.format("%.1f", rating),
            style = MaterialTheme.typography.labelSmall,
            color = ratingYellow
        )
    }
}