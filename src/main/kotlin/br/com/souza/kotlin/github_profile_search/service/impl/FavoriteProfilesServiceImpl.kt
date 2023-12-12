package br.com.souza.kotlin.github_profile_search.service.impl

import br.com.souza.kotlin.github_profile_search.client.IGithubClient
import br.com.souza.kotlin.github_profile_search.database.model.FavoriteProfiles
import br.com.souza.kotlin.github_profile_search.database.repository.IFavoriteProfilesRepository
import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import br.com.souza.kotlin.github_profile_search.handler.exceptions.ProfileAlreadyFavoritedException
import br.com.souza.kotlin.github_profile_search.handler.exceptions.ProfileNotFoundException
import br.com.souza.kotlin.github_profile_search.handler.exceptions.ProfileNotSavedException
import br.com.souza.kotlin.github_profile_search.service.IFavoriteProfilesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class FavoriteProfilesServiceImpl(private val iFavoriteProfilesRepository: IFavoriteProfilesRepository,
                                  private val iGithubClient: IGithubClient) : IFavoriteProfilesService {

    override fun getAllFavorites(): ResponseEntity<List<FavoriteProfiles>> {
        return ResponseEntity(iFavoriteProfilesRepository.findAll().sortedBy { it.login }, HttpStatus.OK)
    }

    override fun saveGithubProfile(@PathVariable("name") name: String) {
        val favProfile = iFavoriteProfilesRepository.findByLogin(name)
        if (favProfile.isPresent) {
            throw ProfileAlreadyFavoritedException(name)
        }

        val githubProfile: GithubProfileResponse
        try{
            githubProfile = iGithubClient.searchGithubProfileByName(name)
        }catch (e: Exception){
            throw ProfileNotFoundException(name)
        }

        iFavoriteProfilesRepository.save(FavoriteProfiles(githubProfile))
    }

    override fun deleteGithubProfile(identifier: String) {
        iFavoriteProfilesRepository.findById(identifier)
            .orElseThrow{ ProfileNotSavedException(identifier) }

        iFavoriteProfilesRepository.deleteById(identifier)
    }
}