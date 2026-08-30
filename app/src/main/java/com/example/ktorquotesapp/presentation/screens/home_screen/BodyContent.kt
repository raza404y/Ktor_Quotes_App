package com.example.ktorquotesapp.presentation.screens.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktorquotesapp.domain.models.Quote
import com.example.ktorquotesapp.presentation.theme.Purple_Light
import com.example.ktorquotesapp.presentation.theme.Purple_Solid

@Composable
fun BodyContent(quotes: List<Quote>) {

    val randomQuote = quotes.random()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(14.dp))
            .background(Purple_Light)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FormatQuote,
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = Purple_Solid
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = randomQuote.quote,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "--${ randomQuote.author }",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Purple_Solid
            )

        } // column
    } // box

    Spacer(Modifier.height(14.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "All Quotes",
            fontWeight = FontWeight.SemiBold
        )

        Card(
            shape = CircleShape,
            border = BorderStroke(width = 1.dp, color = Color.Gray.copy(alpha = .4f)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.FilterAlt,
                    contentDescription = null,
                    tint = Purple_Solid,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "All Filters",
                    fontSize = 14.sp
                )
            }
        }


    } // row



    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(quotes) { singleQuote ->

            QuoteCard(singleQuote)
        }
    }

}