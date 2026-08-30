package com.example.ktorquotesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ktorquotesapp.domain.models.Quote
import com.example.ktorquotesapp.presentation.screens.home_screen.HomeScreen
import com.example.ktorquotesapp.presentation.screens.quote_screen.QuoteScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = QuoteNavGraph.HomeScreen
    ){
        composable <QuoteNavGraph.HomeScreen>{
            HomeScreen(navController)
        }

        composable<QuoteNavGraph.QuoteScreen> { backStack ->
            val route = backStack.toRoute<QuoteNavGraph.QuoteScreen>()
            QuoteScreen(navController,route.id)
        }

    }

}

@Serializable
sealed class QuoteNavGraph {


    @Serializable
    object HomeScreen: QuoteNavGraph()

    @Serializable
    data class QuoteScreen(val id: Int): QuoteNavGraph()
}