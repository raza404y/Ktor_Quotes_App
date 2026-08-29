package com.example.ktorquotesapp.domain.repository

import com.example.ktorquotesapp.domain.models.Quote

interface QuoteRepository {

    suspend fun getQuotes(): List<Quote>

    suspend fun getQuotesById(id: Int): Quote

}