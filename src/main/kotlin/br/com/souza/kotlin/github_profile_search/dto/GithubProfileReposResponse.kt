package br.com.souza.kotlin.github_profile_search.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubProfileReposResponse(
        val name: String,
        @JsonProperty(value = "clone_url")
        val cloneUrl: String,
        @JsonProperty(value = "stargazers_count")
        val starsCount: Int,
        @JsonProperty(value = "language")
        val mainLanguage: String?,
        val visibility: String
)