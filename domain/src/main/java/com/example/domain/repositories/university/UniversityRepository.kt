package com.example.domain.repositories.university

import arrow.core.Either
import com.example.domain.model.university.UniversityInfo

interface UniversityRepository {
    suspend fun getUniversityDetailsList(country: String): Either<Throwable,List<UniversityInfo>>
}