package br.com.souza.kotlin.github_profile_search.database.model

import br.com.souza.kotlin.github_profile_search.dto.GithubProfileResponse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "favorite_profiles")
data class FavoriteProfiles(

    @Id
    val identifier: String = "",
    val login: String = "",
    val name: String = "",
    val company: String? = "",
    val bio: String? = "",
    val location: String? = "",
    val followers: Int = 0,
    val following: Int = 0,
    val publicRepos: Int = 0
){
    constructor(githubProfileResponse: GithubProfileResponse) : this(
        identifier = UUID.randomUUID().toString(),
        login = githubProfileResponse.login,
        name = githubProfileResponse.name,
        company = githubProfileResponse.company,
        bio = githubProfileResponse.bio,
        location = githubProfileResponse.location,
        followers = githubProfileResponse.followers,
        following = githubProfileResponse.following,
        publicRepos = githubProfileResponse.publicRepos
    )
}