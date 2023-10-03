package com.example.domain.model.university

import arrow.core.Option
import arrow.core.none
import arrow.core.some

data class UniversityInfo(
    val country: Option<Country>,
    val alphaTwoCode: String,
    val universityName: String,
    val stateProvince: String,
    val domains: List<Option<Domain>>,
    val webPages: List<String>
) {

}

class Country private constructor(val countryName: String) {
    companion object {
        private const val pattern = "[a-zA-Z]{2,}"
        private val regex = Regex(pattern)
        fun from(name: String): Option<Country> {
            return if(name.matches(regex)) Country(name).some() else none()
        }

        /*fun getName(): String {
            return countryName
        }*/
    }

    /*fun getName(): String {
        return
    }*/
}

class Domain private constructor(val domain: String) {
    companion object {
        private const val pattern = "(?:(?!-|[^.]+_)[A-Za-z0-9-_]{1,63}(?<!-)(?:\\.|\$)){2,}"
        private val regex = Regex(pattern)

        fun from(domain: String): Option<Domain> {
            return if(domain.matches(regex)) Domain(domain).some() else none()
        }
    }
}
