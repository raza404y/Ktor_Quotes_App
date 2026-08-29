package com.example.ktorquotesapp.data.remote

import com.example.ktorquotesapp.data.dto.QuoteDto
import com.example.ktorquotesapp.data.dto.QuotesResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    suspend fun getAllQuotes(): QuotesResponseDto{
        return client.get(urlString = ApiClient.BASE_URL).body()
    }

    suspend fun getQuoteById(id: Int): QuoteDto{
        return client.get(urlString = "${ApiClient.BASE_URL}/$id").body()
    }

}