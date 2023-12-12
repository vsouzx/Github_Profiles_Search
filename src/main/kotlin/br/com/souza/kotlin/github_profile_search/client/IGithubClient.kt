package br.com.souza.kotlin.github_profile_search.client

import br.com.souza.kotlin.github_profile_search.dto.GithubProfileReposResponse
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "Github", url = "https://api.github.com/users")
interface IGithubClient {

    @GetMapping(value = ["/{name}"])
    fun searchGithubProfileByName(@PathVariable("name") name: String): GithubProfileResponse

    @GetMapping(value = ["/{name}/repos"])
    fun searchGithubProfileReposByName(@PathVariable("name") name: String): List<GithubProfileReposResponse>
}