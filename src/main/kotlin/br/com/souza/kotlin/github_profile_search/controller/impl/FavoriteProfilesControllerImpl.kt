package br.com.souza.kotlin.github_profile_search.controller.impl

import br.com.souza.kotlin.github_profile_search.controller.IFavoriteProfilesController
import br.com.souza.kotlin.github_profile_search.database.model.FavoriteProfiles
import br.com.souza.kotlin.github_profile_search.service.IFavoriteProfilesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/v1/favorite"])
class FavoriteProfilesControllerImpl(private val iFavoriteProfilesService: IFavoriteProfilesService) : IFavoriteProfilesController{

    @GetMapping(value = ["/all"])
    override fun getAllFavorites(): ResponseEntity<List<FavoriteProfiles>> {
        return iFavoriteProfilesService.getAllFavorites()
    }

    @PostMapping(value = ["/{name}"])
    override fun saveGithubProfile(@PathVariable("name") name: String) {
        iFavoriteProfilesService.saveGithubProfile(name)
    }

    @DeleteMapping(value = ["/{identifier}"])
    override fun deleteGithubProfile(@PathVariable("identifier") identifier: String) {
        iFavoriteProfilesService.deleteGithubProfile(identifier)
    }
}