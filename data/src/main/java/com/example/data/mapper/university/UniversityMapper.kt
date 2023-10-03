package com.example.data.mapper.university

import arrow.core.Either
import arrow.core.Option
import com.example.data.model.university.UniversityNetworkInfo
import com.example.domain.mapper.Mapper
import com.example.domain.model.university.Country
import com.example.domain.model.university.Domain
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
                Country.from(it.country),
                it.alphaTwoCode ?: "",
                it.universityName,
                it.stateProvince ?: "",
                toListDomain(it.domains),
                it.webPages ?: emptyList()
            )
        }
    }

    private fun toListDomain(list: List<String>?): List<Option<Domain>> {
        return list?.map {
            Domain.from(it)
        } ?: emptyList()
    }
}