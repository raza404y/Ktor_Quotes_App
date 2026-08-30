package com.example.ktorquotesapp.presentation.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ktorquotesapp.domain.models.Quote
import com.example.ktorquotesapp.presentation.theme.Purple_Extra_Light
import com.example.ktorquotesapp.presentation.theme.Purple_Light
import com.example.ktorquotesapp.presentation.theme.Purple_Solid

@Composable
fun QuoteCard(
    singleQuote: Quote,
    onQuoteClick: () -> Unit
) {

    Spacer(Modifier.height(14.dp))

    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = {onQuoteClick()}),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = CircleShape)
                    .background(color = Purple_Extra_Light),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = null,
                    tint = Purple_Solid
                )
            }
            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = singleQuote.quote,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = " -- ${singleQuote.author}",
                    color = Purple_Solid,
                    modifier = Modifier.padding(top = 6.dp)
                )
            } // column
            Icon(
                imageVector = Icons.Default.BookmarkBorder,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .weight(.13f)
            )
        }


    }


}