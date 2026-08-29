package com.example.ktorquotesapp.presentation.viewmodels.quote_viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorquotesapp.domain.use_case.GetQuotesByIdUseCase
import com.example.ktorquotesapp.presentation.ui_components.QuoteUiState
import kotlinx.coroutines.launch

class QuoteViewModel(private val getQuotesByIdUseCase: GetQuotesByIdUseCase) : ViewModel() {

    private var state by mutableStateOf(QuoteUiState())


    fun loadQuoteById(id: Int) {

        viewModelScope.launch {

            state = state.copy(isLoading = true)

            try {
                val quoteById = getQuotesByIdUseCase(id)
                state = state.copy(
                    isLoading = false,
                    quote = quoteById,
                    error = null
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = e.localizedMessage
                )
            } finally {
                state = state.copy(
                    isLoading = false
                )
            }

        }


    }


}