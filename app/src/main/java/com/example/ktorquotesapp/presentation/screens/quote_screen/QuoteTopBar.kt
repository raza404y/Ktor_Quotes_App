package com.example.ktorquotesapp.presentation.screens.quote_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ktorquotesapp.presentation.theme.Purple_Solid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteTopBar(
    onBackClick: () -> Unit,
) {

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {onBackClick()}
            ) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = null)
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Purple_Solid,
            )

            Spacer(Modifier.width(12.dp))

            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = null
            )
        },
        title = {
            Text("Quote",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
        },
    )

}