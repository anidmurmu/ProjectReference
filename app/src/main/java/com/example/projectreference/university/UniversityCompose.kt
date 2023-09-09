package com.example.projectreference.university

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.domain.model.university.UniversityInfo

@Composable
fun DisplayUniversityUi(viewModel: UniversityViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    HandleState(uiState.state)
}

@Composable
fun HandleState(state: UniversityUiState.State) {
    when(state) {
        is UniversityUiState.State.Initial -> {}
        is UniversityUiState.State.Error-> {}
        is UniversityUiState.State.Success -> {
            DisplayUniversitiesInfo(universityList = state.userList)
        }
    }
}

@Composable
fun DisplayUniversitiesInfo(universityList: List<UniversityInfo>) {
    LazyColumn {
        items(universityList) {university ->
            UniversityListItem(universityInfo = university)
        }
    }
}
@Composable
fun UniversityListItem(universityInfo: UniversityInfo) {
    Column {
        Text(text = universityInfo.universityName)
        Text(text = universityInfo.country)
    }
}