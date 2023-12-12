package br.com.souza.kotlin.github_profile_search.dto

data class CustomErrorResponse(
        val status: Int,
        val error: String? = "Internal Error",
)