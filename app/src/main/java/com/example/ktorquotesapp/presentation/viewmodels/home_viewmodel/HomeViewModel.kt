package com.example.ktorquotesapp.presentation.viewmodels.home_viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorquotesapp.domain.use_case.GetQuoteUseCase
import com.example.ktorquotesapp.presentation.ui_components.HomeUiState
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getQuoteUseCase: GetQuoteUseCase
): ViewModel() {

    private val _state = mutableStateOf(HomeUiState())
    val state: State<HomeUiState> = _state

    init {
        loadQuotes()
    }

    private fun loadQuotes(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            try {
                val quoteList = getQuoteUseCase()

              _state.value = _state.value.copy(
                    isLoading = false,
                    quotes = quoteList,
                    error = null
                )

            }catch (e: Exception){
               _state.value = _state.value.copy(
                   isLoading = false,
                   error = e.localizedMessage
               )
            }finally {
                _state.value =_state.value.copy(
                    isLoading = false
                )
            }
        }
    }

}