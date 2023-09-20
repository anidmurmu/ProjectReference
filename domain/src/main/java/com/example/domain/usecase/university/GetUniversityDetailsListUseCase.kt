package com.example.domain.usecase.university

import arrow.core.Either
import com.example.domain.repositories.university.UniversityRepository
import com.example.domain.model.university.UniversityInfo
import javax.inject.Inject

interface GetUniversityDetailsListUseCase {
    suspend fun getUniversityDetailsList(country: String): Either<Throwable, List<UniversityInfo>>
}

class GetUniversityDetailsListUseCaseImpl @Inject constructor(private val universityRepository: UniversityRepository) :
    GetUniversityDetailsListUseCase {
    override suspend fun getUniversityDetailsList(country: String): Either<Throwable, List<UniversityInfo>> {
        return universityRepository.getUniversityDetailsList(country)
    }
}