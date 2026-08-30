package com.example.ktorquotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ktorquotesapp.presentation.navigation.NavGraph
import com.example.ktorquotesapp.presentation.screens.home_screen.HomeScreen
import com.example.ktorquotesapp.presentation.screens.quote_screen.QuoteScreen
import com.example.ktorquotesapp.presentation.theme.KtorQuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtorQuotesAppTheme {
                NavGraph()
            }
        }
    }
}

