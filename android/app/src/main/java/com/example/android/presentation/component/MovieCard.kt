package com.example.android.presentation.component

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.android.data.model.FakeMovieResponse
import com.example.android.data.model.MovieModel
import com.example.android.ui.theme.Spaces

@Composable
fun MovieCard(
    movie: MovieModel = FakeMovieResponse,
    onWatchlistClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    val cardShape = MaterialTheme.shapes.medium

    Row(
        modifier = Modifier
            .fillMaxWidth(0.96f)
            .height(232.dp)
            .clip(cardShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            . clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // --------------------------------------------------
        // Poster
        // --------------------------------------------------
        AsyncImage(
            model = movie.posterPath,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(130.dp)
                .fillMaxHeight()
                .clip(MaterialTheme.shapes.small)
        )

        // --------------------------------------------------
        // Movie Information
        // --------------------------------------------------
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

                // Title + Watchlist
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {

                    Text(
                        text = movie.title,
                        modifier = Modifier.weight(1f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

//                    IconButton(
//                        onClick = onWatchlistClick,
//                        modifier = Modifier.size(32.dp)
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.BookmarkBorder,
//                            contentDescription = "Add to watchlist",
//                            tint = MaterialTheme.colorScheme.onPrimaryContainer
//                        )
//                    }
                }

                Spacer(
                    modifier = Modifier.height(Spaces.sm)
                )

                // Rating + Year + Adult Rating
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        Spaces.sm
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RatingChip(
                        rating = movie.rating
                    )

                    movie.releaseDate
                        ?.takeIf { it.length >= 4 }
                        ?.let {
                            Chip(
                                title = it.take(4)
                            )
                        }

                    Chip(
                        title = if (movie.adult) "18+" else "PG"
                    )
                }

                Spacer(
                    modifier = Modifier.height(Spaces.sm)
                )

                // Overview
                Text(
                    text = movie.overview.ifBlank {
                        "No overview available."
                    },
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )

                Spacer(
                    modifier = Modifier.height(Spaces.sm)
                )

                // Add To Watchlist Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = onWatchlistClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(34.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            contentColor = MaterialTheme.colorScheme.tertiary
                        ),
                        shape = MaterialTheme.shapes.small,
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = Spaces.xs,
                            pressedElevation = 0.dp
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(Spaces.xs)
                        )

                        Text(
                            text = "Add to Watchlist",
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }
        }
    }
}





