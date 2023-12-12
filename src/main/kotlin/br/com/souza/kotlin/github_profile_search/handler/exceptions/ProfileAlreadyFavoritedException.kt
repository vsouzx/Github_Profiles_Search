package br.com.souza.kotlin.github_profile_search.handler.exceptions

class ProfileAlreadyFavoritedException : CustomException {

    constructor(): super("Profile is already favorite.")
    constructor(message: String): super("Profile is already favorite: $message")
}