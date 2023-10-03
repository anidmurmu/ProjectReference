package com.example.projectreference.university

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arrow.core.Option
import arrow.core.getOrElse
import arrow.core.left
import arrow.core.some
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.model.university.Country
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
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UniversityListItem(universityInfo: UniversityInfo) {
        Card(modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(88.dp)) {
            Box(contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()) {
                    Text(text = universityInfo.universityName,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier
                        .padding(start = 8.dp,top = 8.dp, end = 8.dp))
                    val country = universityInfo.country
                    CountryName(country = universityInfo.country)
                    /*Text(text = universityInfo.country.getOrElse { "" },
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier
                        .padding(start = 8.dp, bottom = 8.dp, end = 8.dp))*/
                    /*GlideImage(model = "https://www.gravatar.com/avatar/8af4e652604bf9f952fded9930f74a37",
                        contentDescription = "this is dummy text",
                        modifier = Modifier
                            .fillMaxSize()
                            .size(40.dp))*/
                    /*GlideImage(model = "https://image.tmdb.org/t/p/w500/8pjWz2lt29KyVGoq1mXYu6Br7dE.jpg",
                        contentDescription = "this is dummy text",
                        modifier = Modifier
                            .fillMaxSize()
                            .size(40.dp))*/
                }
            }
        }
}

@Composable
fun CountryName(country: Option<Country>) {
    country.map {
        //Text(text = country.country.getOrElse { "" },
        val abc: String = it.countryName
        Text(text = abc,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            fontStyle = FontStyle.Normal,
            modifier = Modifier
                .padding(start = 8.dp, bottom = 8.dp, end = 8.dp))
    }
}