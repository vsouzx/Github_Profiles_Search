package br.com.souza.kotlin.github_profile_search.service

import br.com.souza.kotlin.github_profile_search.database.model.FavoriteProfiles
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileReposResponse
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

interface IFavoriteProfilesService {

    fun getAllFavorites(): ResponseEntity<List<FavoriteProfiles>>
    fun saveGithubProfile(name: String)
    fun deleteGithubProfile(identifier: String)
}