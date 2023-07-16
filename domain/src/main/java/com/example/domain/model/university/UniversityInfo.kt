package com.example.domain.model.university

data class UniversityInfo(
    val country: String,
    val alphaTwoCode: String,
    val universityName: String,
    val stateProvince: String,
    val domains: List<String>,
    val webPages: List<String>
)
