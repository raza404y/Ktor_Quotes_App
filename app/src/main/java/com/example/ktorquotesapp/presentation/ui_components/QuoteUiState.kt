package com.example.ktorquotesapp.presentation.ui_components

import com.example.ktorquotesapp.domain.models.Quote

data class QuoteUiState(
    val isLoading: Boolean = false,
    val quote: Quote? = null,
    val error: String? = null
    )
