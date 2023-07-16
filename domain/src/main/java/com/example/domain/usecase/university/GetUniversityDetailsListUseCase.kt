package com.example.domain.usecase.university

import com.example.domain.repositories.university.UniversityRepository
import com.example.domain.model.university.UniversityInfo

interface GetUniversityDetailsListUseCase {
    suspend fun getUniversityDetailsList(country: String): Result<List<UniversityInfo>>
}

class GetUniversityDetailsListUseCaseImpl(private val universityRepository: UniversityRepository) :
    GetUniversityDetailsListUseCase {
    override suspend fun getUniversityDetailsList(country: String): Result<List<UniversityInfo>> {
        return universityRepository.getUniversityDetailsList(country)
    }
}