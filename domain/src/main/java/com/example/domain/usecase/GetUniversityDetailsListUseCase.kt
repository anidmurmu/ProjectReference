package com.example.domain.usecase

import com.example.domain.repositories.UniversityRepository
import com.example.projectreference.domain.model.UniversityInfo

interface GetUniversityDetailsListUseCase {
    suspend fun getUniversityDetailsList(): Result<List<UniversityInfo>>
}

class GetUniversityDetailsListUseCaseImpl(private val universityRepository: UniversityRepository) : GetUniversityDetailsListUseCase {
    override suspend fun getUniversityDetailsList(): Result<List<UniversityInfo>> {
        return universityRepository.getUniversityDetailsList()
    }
}