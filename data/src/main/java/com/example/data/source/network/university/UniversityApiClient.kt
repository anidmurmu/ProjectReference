package com.example.data.source.network.university

import com.example.data.model.university.UniversityNetworkInfo
import com.example.domain.model.university.UniversityInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiClient {
    @GET("search")
    suspend fun getUniversityDetailsList(@Query("country")country: String): List<UniversityNetworkInfo>
}