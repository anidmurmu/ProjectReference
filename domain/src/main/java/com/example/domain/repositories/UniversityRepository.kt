package com.example.domain.repositories

import com.example.projectreference.domain.model.UniversityInfo

interface UniversityRepository {
    suspend fun getUniversityDetailsList(): Result<List<UniversityInfo>>
}