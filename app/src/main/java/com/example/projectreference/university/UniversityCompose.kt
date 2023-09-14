package com.example.projectreference.university

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    LazyColumn(modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items(universityList) {university ->
            UniversityListItem(universityInfo = university)
        }
    }
}
@Composable
fun UniversityListItem(universityInfo: UniversityInfo) {
        Card(modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(88.dp)) {
            Box(contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight()) {
                    Text(text = universityInfo.universityName, modifier = Modifier
                        .padding(start = 8.dp,top = 8.dp, end = 8.dp))
                    Text(text = universityInfo.country, modifier = Modifier
                        .padding(start = 8.dp, bottom = 8.dp, end = 8.dp))
                }
            }
        }
}