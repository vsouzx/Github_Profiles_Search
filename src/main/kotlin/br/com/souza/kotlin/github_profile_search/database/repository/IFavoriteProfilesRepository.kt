package br.com.souza.kotlin.github_profile_search.database.repository

import br.com.souza.kotlin.github_profile_search.database.model.FavoriteProfiles
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IFavoriteProfilesRepository: MongoRepository<FavoriteProfiles, String>{

    fun findByLogin(login: String): Optional<FavoriteProfiles>
}


