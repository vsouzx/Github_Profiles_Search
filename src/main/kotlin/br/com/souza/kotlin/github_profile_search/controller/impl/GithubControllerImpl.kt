package br.com.souza.kotlin.github_profile_search.controller.impl

import br.com.souza.kotlin.github_profile_search.controller.IGithubController
import br.com.souza.kotlin.github_profile_search.service.IGithubService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/v1/search"])
class GithubControllerImpl(private val iGithubService: IGithubService) : IGithubController{

    @GetMapping(value = ["/{name}"])
    override fun searchProfileByName(@PathVariable("name") name: String) = iGithubService.searchProfileByName(name)

    @GetMapping(value = ["/{name}/mostlikedrepos"])
    override fun searchProfileReposByName(@PathVariable("name") name: String) = iGithubService.searchProfileReposByName(name)
}