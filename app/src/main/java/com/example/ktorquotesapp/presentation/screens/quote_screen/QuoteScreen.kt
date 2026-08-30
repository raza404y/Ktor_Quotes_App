package com.example.ktorquotesapp.presentation.screens.quote_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ktorquotesapp.presentation.navigation.QuoteNavGraph
import com.example.ktorquotesapp.presentation.theme.Purple_Solid
import com.example.ktorquotesapp.presentation.ui_components.ErrorMessage
import com.example.ktorquotesapp.presentation.ui_components.MyProgressBar
import com.example.ktorquotesapp.presentation.viewmodels.quote_viewmodel.QuoteViewModel
import com.example.ktorquotesapp.presentation.viewmodels.quote_viewmodel.QuoteViewModelFactory

@Composable
fun QuoteScreen(
    navController: NavController,
    id: Int,
    viewModel: QuoteViewModel = viewModel(factory = QuoteViewModelFactory())
) {

    LaunchedEffect(key1 = id) {
        viewModel.loadQuoteById(id)
    }

    Scaffold(
        modifier = Modifier.padding(end = 12.dp),
        topBar = {QuoteTopBar(
            onBackClick = {navController.navigate(QuoteNavGraph.HomeScreen)}
        )}
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it)
        ) {

            when {
                viewModel.state.isLoading -> MyProgressBar()
                viewModel.state.error !=null ->{
                    ErrorMessage(
                        errorMessage = viewModel.state.error,
                        onRetryClick = {viewModel.loadQuoteById(id)}
                    )
                }
                viewModel.state.quote !=null ->{

                    val currentQuote = viewModel.state.quote

                    Box(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier =
                            Modifier.fillMaxSize()
                                .padding(26.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FormatQuote,
                                contentDescription = null,
                                Modifier.size(42.dp),
                                tint = Purple_Solid
                            )

                            Spacer(Modifier.height(14.dp))
                            Text(
                                text = currentQuote!!.quote,
                                fontSize = 26.sp
                            )

                            Spacer(Modifier.height(14.dp))
                            Text(
                                text = "--${currentQuote.author}",
                                fontSize = 26.sp,
                                color = Purple_Solid
                            )
                        }
                    }
                }
            }

        }
    }


}