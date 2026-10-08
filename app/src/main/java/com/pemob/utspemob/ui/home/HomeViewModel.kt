package com.pemob.utspemob.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pemob.utspemob.data.model.Meal
import com.pemob.utspemob.data.repository.RecipeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val meals: List<Meal>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

class HomeViewModel : ViewModel() {
    private val repository = RecipeRepository()
    
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery
    
    private var searchJob: Job? = null

    init {
        viewModelScope.launch {
            searchMeals("")
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500.milliseconds) // debounce for typing
            searchMeals(query)
        }
    }

    private suspend fun searchMeals(query: String) {
        _uiState.value = HomeUiState.Loading
        try {
            val result = repository.searchMeals(query)
            if (result != null) {
                _uiState.value = HomeUiState.Success(result)
            } else {
                _uiState.value = HomeUiState.Success(emptyList()) // API returns null if no results
            }
        } catch (e: Exception) {
            _uiState.value = HomeUiState.Error(e.message ?: "Unknown error occurred")
        }
    }
}
