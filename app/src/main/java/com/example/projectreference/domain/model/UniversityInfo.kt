package com.example.projectreference.domain.model

data class UniversityInfo(
    val country: String,
    val alphaTwoCode: String,
    val universityName: String,
    val stateProvince: String,
    val domains: List<String>,
    val webPages: List<String>
)
