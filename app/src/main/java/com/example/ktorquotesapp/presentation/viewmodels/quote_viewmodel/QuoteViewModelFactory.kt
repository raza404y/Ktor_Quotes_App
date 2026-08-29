package com.example.ktorquotesapp.presentation.viewmodels.quote_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ktorquotesapp.data.remote.ApiClient
import com.example.ktorquotesapp.data.remote.ApiService
import com.example.ktorquotesapp.data.repository.QuoteRepositoryImpl
import com.example.ktorquotesapp.domain.use_case.GetQuotesByIdUseCase

@Suppress("UNCHECKED_CAST")
class QuoteViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val apiService = ApiService(ApiClient.client)
        val repository = QuoteRepositoryImpl(apiService)
        val useCaseGetQuoteById = GetQuotesByIdUseCase(repository)

        return QuoteViewModel(useCaseGetQuoteById) as T

    }

}