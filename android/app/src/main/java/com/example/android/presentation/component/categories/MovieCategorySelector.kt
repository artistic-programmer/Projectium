package com.example.android.presentation.component.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MovieCategorySelector(
    selectedCategory: MovieCategory,
    onCategorySelected: (MovieCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        CategoryChip(
            title = "Popular",
            selected = selectedCategory == MovieCategory.POPULAR,
            onClick = {
                onCategorySelected(MovieCategory.POPULAR)
            }
        )

        CategoryChip(
            title = "Top Rated",
            selected = selectedCategory == MovieCategory.TOP_RATED,
            onClick = {
                onCategorySelected(MovieCategory.TOP_RATED)
            }
        )

        CategoryChip(
            title = "Upcoming",
            selected = selectedCategory == MovieCategory.UPCOMING,
            onClick = {
                onCategorySelected(MovieCategory.UPCOMING)
            }
        )
    }
}