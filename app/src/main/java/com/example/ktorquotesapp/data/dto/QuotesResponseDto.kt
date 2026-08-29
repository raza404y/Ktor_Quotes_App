package com.example.ktorquotesapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class QuotesResponseDto(
    val limit: Int,
    val quotes: List<QuoteDto>,
    val skip: Int,
    val total: Int
)