package br.com.souza.kotlin.github_profile_search.service

import br.com.souza.kotlin.github_profile_search.dto.GithubProfileReposResponse
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import org.springframework.http.ResponseEntity

interface IGithubService {

    fun searchProfileByName(name: String): ResponseEntity<GithubProfileResponse>

    fun searchProfileReposByName(name: String): ResponseEntity<List<GithubProfileReposResponse>>
}