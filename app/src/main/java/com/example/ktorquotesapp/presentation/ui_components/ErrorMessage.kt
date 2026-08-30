package com.example.ktorquotesapp.presentation.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktorquotesapp.presentation.theme.Purple_Solid

@Composable
fun ErrorMessage(
    errorMessage: String?,
    onRetryClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = errorMessage ?: "",
            color = MaterialTheme.colorScheme.error,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {onRetryClick()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple_Solid
            )
        ) {
            Text(
                "Retry",
                fontSize = 16.sp
            )
        }


    }

}