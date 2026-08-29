package com.example.ktorquotesapp.presentation.ui_components

import com.example.ktorquotesapp.domain.models.Quote

data class HomeUiState(
    val isLoading: Boolean = false,
    val quotes: List<Quote> = emptyList(),
    val error: String? = null
    )