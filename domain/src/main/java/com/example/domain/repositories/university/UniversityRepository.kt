package com.example.domain.repositories.university

import com.example.domain.model.university.UniversityInfo

interface UniversityRepository {
    suspend fun getUniversityDetailsList(country: String): Result<List<UniversityInfo>>
}