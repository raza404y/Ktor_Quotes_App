package com.example.ktorquotesapp.presentation.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ktorquotesapp.presentation.ui_components.ErrorMessage
import com.example.ktorquotesapp.presentation.ui_components.MyProgressBar
import com.example.ktorquotesapp.presentation.viewmodels.home_viewmodel.HomeViewModel
import com.example.ktorquotesapp.presentation.viewmodels.home_viewmodel.HomeViewModelFactory

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory())
) {
    val uiState = viewModel.state.value

    Scaffold(
        modifier = Modifier.padding(end = 12.dp),
        topBar = { HomeTopBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 19.dp)
        ) {

            Text(
                text = "Words to inspire, thoughts to reflect,\nand wisdom to live by.",
                fontSize = 15.sp,
                color = Color.DarkGray.copy(alpha = .8f),
            )

            Spacer(modifier = Modifier.height(14.dp))



            when {

                uiState.isLoading -> MyProgressBar()
                uiState.error != null -> {
                    ErrorMessage(
                        errorMessage = uiState.error,
                        onRetryClick = {viewModel.loadQuotes()}
                    )
                }
                else ->{
                    BodyContent(navController,uiState.quotes)
                }

            }


        }
    }
}