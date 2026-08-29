package com.example.ktorquotesapp.presentation.viewmodels.home_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ktorquotesapp.data.remote.ApiClient
import com.example.ktorquotesapp.data.remote.ApiService
import com.example.ktorquotesapp.data.repository.QuoteRepositoryImpl
import com.example.ktorquotesapp.domain.repository.QuoteRepository
import com.example.ktorquotesapp.domain.use_case.GetQuoteUseCase


@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val apiService = ApiService(ApiClient.client)
        val repository = QuoteRepositoryImpl(apiService)
        val useCaseGetQuote = GetQuoteUseCase(repository)
        return HomeViewModel(useCaseGetQuote) as T
    }

}