package br.com.souza.kotlin.github_profile_search.controller

import br.com.souza.kotlin.github_profile_search.dto.GithubProfileReposResponse
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import org.springframework.http.ResponseEntity

interface IGithubController {

    fun searchProfileByName(name: String): ResponseEntity<GithubProfileResponse>
    fun searchProfileReposByName(name: String): ResponseEntity<List<GithubProfileReposResponse>>
}