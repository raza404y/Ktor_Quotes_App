package com.example.ktorquotesapp.data.dto

import com.example.ktorquotesapp.domain.models.Quote
import kotlinx.serialization.Serializable

@Serializable
data class QuoteDto(
    val author: String,
    val id: Int,
    val quote: String
)

fun QuoteDto.toDomainQuote(): Quote{
    return Quote(
        id = this.id,
        quote = this.quote,
        author = this.author
    )
}