package com.example.projectreference.university

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.domain.usecase.university.GetUniversityDetailsListUseCase
import com.example.projectreference.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getUniversityDetailsListUseCase: GetUniversityDetailsListUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UniversityUiState> =
        MutableStateFlow(UniversityUiState())
    val uiState: StateFlow<UniversityUiState> = _uiState

    fun getUniversityList() {
        viewModelScope.launch(dispatcherProvider.io) {
            val response = getUniversityDetailsListUseCase.getUniversityDetailsList("India")
            when(response) {
                is Either.Right -> {
                    _uiState.value = _uiState.value.copy(state =UniversityUiState.State.Success(response.value))
                }
                is Either.Left -> {
                    _uiState.value = _uiState.value.copy(state =UniversityUiState.State.Error(response.value.toString()))
                }
            }
        }
    }
}