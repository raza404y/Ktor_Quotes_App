package com.example.ktorquotesapp.domain.use_case

import com.example.ktorquotesapp.domain.models.Quote
import com.example.ktorquotesapp.domain.repository.QuoteRepository

class GetQuoteUseCase(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote>{
        return repository.getQuotes()
    }

}
