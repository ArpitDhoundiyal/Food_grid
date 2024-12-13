package com.example.food_grid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlashViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(FlashUiState())
    val uiState: StateFlow<FlashUiState> = _uiState.asStateFlow()

    val _isVisible = MutableStateFlow(true)
    val isVisible = _isVisible

    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user : MutableStateFlow<FirebaseUser?> get() = _user

    fun updateClickText(updateText: String) {
        _uiState.update {
            it.copy(clickStatus = updateText)

        }
    }


    fun updateSelectedCategory(updatedCategory: Int) {
        _uiState.update {
            it.copy(selectedCategory = updatedCategory)
        }

    }

        fun toggleVisibility() {
        _isVisible.value = false
    }

    init {
        viewModelScope.launch(Dispatchers.Default) {
            delay(3000)
            toggleVisibility()

        }
    }

}