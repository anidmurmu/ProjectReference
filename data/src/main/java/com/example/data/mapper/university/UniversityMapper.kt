package com.example.data.mapper.university

import arrow.core.Either
import com.example.data.model.university.UniversityNetworkInfo
import com.example.domain.mapper.Mapper
import com.example.domain.model.university.UniversityInfo
import javax.inject.Inject

class UniversityMapper @Inject constructor() : Mapper<List<UniversityNetworkInfo>, Either<Throwable, List<UniversityInfo>>> {
    override fun map(src: List<UniversityNetworkInfo>): Either<Throwable, List<UniversityInfo>> {
        val result = try {
            val list = toUiModelList(src)
            Either.Right(list)
        } catch (ex: Exception) {
            Either.Left(ex)
        }
        return result
    }

    private fun toUiModelList(src: List<UniversityNetworkInfo>): List<UniversityInfo> {
        return src.map {
            UniversityInfo(
                it.country,
                it.alphaTwoCode ?: "",
                it.universityName,
                it.stateProvince ?: "",
                it.domains ?: emptyList(),
                it.webPages ?: emptyList()
            )
        }
    }
}