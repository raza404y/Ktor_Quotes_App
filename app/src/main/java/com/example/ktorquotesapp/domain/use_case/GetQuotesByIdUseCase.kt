package com.example.ktorquotesapp.domain.use_case

import com.example.ktorquotesapp.domain.models.Quote
import com.example.ktorquotesapp.domain.repository.QuoteRepository

class GetQuotesByIdUseCase(private val quoteRepository: QuoteRepository,) {

    suspend operator fun invoke(id: Int): Quote{
        return quoteRepository.getQuotesById(id)
    }

}