package br.com.souza.kotlin.github_profile_search.dto

data class GithubProfileResponse(
        val login: String,
        val name: String,
        val company: String? = null,
        val bio: String? = null,
        val location: String? = null,
        val followers: Int,
        val following: Int,
        val publicRepos: Int
)