package com.example.data.mapper.university

import com.example.data.model.university.UniversityNetworkInfo
import com.example.domain.mapper.Mapper
import com.example.domain.model.university.UniversityInfo
import javax.inject.Inject

class UniversityMapper @Inject constructor() : Mapper<List<UniversityNetworkInfo>, Result<List<UniversityInfo>>> {
    override fun map(src: List<UniversityNetworkInfo>): Result<List<UniversityInfo>> {
        val result = try {
            val list = toUiModelList(src)
            Result.success(list)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
        return result
    }

    private fun toUiModelList(src: List<UniversityNetworkInfo>): List<UniversityInfo> {
        return src.map {
            UniversityInfo(
                it.country,
                it.alphaTwoCode,
                it.universityName,
                it.stateProvince,
                it.domains,
                it.webPages
            )
        }
    }
}