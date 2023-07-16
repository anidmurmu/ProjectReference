package com.example.projectreference.university

import com.example.domain.model.university.UniversityInfo

data class UniversityUiState(val state: State = State.Initial) {
    sealed class State() {
        object Initial : State()
        data class Error(val error: String) : State()
        data class Success(val userList: List<UniversityInfo>) : State()
    }
}
