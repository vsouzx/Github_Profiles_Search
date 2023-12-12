package br.com.souza.kotlin.github_profile_search.service.impl

import br.com.souza.kotlin.github_profile_search.client.IGithubClient
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileReposResponse
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import br.com.souza.kotlin.github_profile_search.handler.exceptions.ProfileNotFoundException
import br.com.souza.kotlin.github_profile_search.service.IGithubService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class GithubServiceImpl(private val iGithubClient: IGithubClient) : IGithubService {

    override fun searchProfileByName(name: String): ResponseEntity<GithubProfileResponse> {
        val response: GithubProfileResponse
        try {
            response = iGithubClient.searchGithubProfileByName(name)
        }catch (e: Exception){
            throw ProfileNotFoundException(name)
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    override fun searchProfileReposByName(name: String): ResponseEntity<List<GithubProfileReposResponse>> {
        try {
            iGithubClient.searchGithubProfileByName(name)
        }catch (e: Exception){
            throw ProfileNotFoundException(name)
        }
        return ResponseEntity(iGithubClient.searchGithubProfileReposByName(name).sortedByDescending { it.starsCount }, HttpStatus.OK)
    }
}