package br.com.souza.kotlin.github_profile_search.controller

import br.com.souza.kotlin.github_profile_search.database.model.FavoriteProfiles
import org.springframework.http.ResponseEntity

interface IFavoriteProfilesController {

    fun getAllFavorites(): ResponseEntity<List<FavoriteProfiles>>
    fun saveGithubProfile(name: String)
    fun deleteGithubProfile(identifier: String)
}