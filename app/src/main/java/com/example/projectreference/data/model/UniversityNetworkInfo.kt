package com.example.projectreference.data.model

data class UniversityNetworkInfo(
    @S
    val country: String,
    val alphaTwoCode: String,
    val universityName: String,
    val stateProvince: String,
    val domains: List<String>,
    val webPages: List<String>
)

"country": "India",
"alpha_two_code": "IN",
"name": "DAV Institute of Engineering & Technology",
"state-province": "Punjab",
"domains": [
"davietjal.org"
],
"web_pages": [
"http://www.davietjal.org/"
]
