package com.example.data.repo_impl.university

import com.example.data.mapper.university.UniversityMapper
import com.example.data.source.network.university.UniversityApiClient
import com.example.domain.model.university.UniversityInfo
import com.example.domain.repositories.university.UniversityRepository
import javax.inject.Inject

class UniversityRepoImpl @Inject constructor(
    private val universityApiClient: UniversityApiClient,
    private val universityMapper: UniversityMapper
) : UniversityRepository {
    override suspend fun getUniversityDetailsList(country: String): Result<List<UniversityInfo>> {
        return universityMapper.map(universityApiClient.getUniversityDetailsList(country))
        /*val list = emptyList<UniversityInfo>()
        return Result.success(list)*/
    }
}