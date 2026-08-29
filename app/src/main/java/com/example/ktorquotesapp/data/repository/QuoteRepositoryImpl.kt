package com.example.ktorquotesapp.data.repository

import com.example.ktorquotesapp.data.dto.toDomainQuote
import com.example.ktorquotesapp.data.remote.ApiService
import com.example.ktorquotesapp.domain.models.Quote
import com.example.ktorquotesapp.domain.repository.QuoteRepository

class QuoteRepositoryImpl(private val apiService: ApiService): QuoteRepository {

    override suspend fun getQuotes(): List<Quote> {
        // get raw data from api service
        val responseDto = apiService.getAllQuotes()

        // and use mapper function to take data from dto and give it to domain Quote
        return responseDto.quotes.map { it->
            it.toDomainQuote()
        }

    }

    override suspend fun getQuotesById(id: Int): Quote {
        val quote = apiService.getQuoteById(id)
        return quote.toDomainQuote()
    }


}