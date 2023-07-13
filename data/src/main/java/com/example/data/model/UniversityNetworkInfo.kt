package com.example.data.model

import com.google.gson.annotations.SerializedName

data class UniversityNetworkInfo(
    @SerializedName("country")
    val country: String,
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,
    @SerializedName("name")
    val universityName: String,
    @SerializedName("state-province")
    val stateProvince: String,
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("web_pages")
    val webPages: List<String>
)


