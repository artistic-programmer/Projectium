package com.example.android.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchBar(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    SearchBar(
        modifier = modifier
            .fillMaxWidth(0.96f),

        inputField = {
            SearchBarDefaults.InputField(
                query = textFieldState.text.toString(),

                onQueryChange = { newQuery ->
                    textFieldState.edit {
                        replace(0, length, newQuery)
                    }
                },

                onSearch = {
                    onSearch(textFieldState.text.toString())
                    expanded = false
                },

                expanded = expanded,

                onExpandedChange = {
                    expanded = it
                },

                placeholder = {
                    Text(
                        text = "Search movies...",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },

                trailingIcon = {
                    if (textFieldState.text.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                textFieldState.edit {
                                    replace(0, length, "")
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear search"
                            )
                        }
                    }
                }
            )
        },

        expanded = expanded,

        onExpandedChange = {
            expanded = it
        },
        windowInsets = WindowInsets(0, 0, 0, 0)
    ) {
        // Search suggestions/results will be added later.
    }
}
