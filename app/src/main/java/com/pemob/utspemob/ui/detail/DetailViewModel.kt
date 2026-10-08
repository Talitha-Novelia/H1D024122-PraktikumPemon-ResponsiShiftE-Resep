package com.pemob.utspemob.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pemob.utspemob.data.model.Meal
import com.pemob.utspemob.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val meal: Meal) : DetailUiState()
    data class Error(val message: String) : DetailUiState()
}

class DetailViewModel : ViewModel() {
    private val repository = RecipeRepository()
    
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    fun getMealDetails(id: String) {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            try {
                val result = repository.getMealById(id)
                if (result != null) {
                    _uiState.value = DetailUiState.Success(result)
                } else {
                    _uiState.value = DetailUiState.Error("Recipe not found.")
                }
            } catch (e: Exception) {
                _uiState.value = DetailUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}
