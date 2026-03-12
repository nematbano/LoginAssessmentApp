package com.example.loginassessmentapp

import androidx.lifecycle.ViewModel
import com.example.loginassessmentapp.utils.LoginError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val CORRECT_PASSWORD = "Test@2026"

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.None)
    val uiState: StateFlow<UiState> = _uiState

    fun validateLogin(password: String) {
        when {
            password.isBlank() ->
                _uiState.value = UiState.Error(LoginError.BLANK_PASSWORD)

            password == CORRECT_PASSWORD ->
                _uiState.value = UiState.Success

            else ->
                _uiState.value = UiState.Error(LoginError.WRONG_PASSWORD)
        }
    }

    fun resetUiState() {
        _uiState.value = UiState.None
    }
}

sealed class UiState {
    object None : UiState()
    object Success : UiState()
    data class Error(val type: LoginError) : UiState()
}