package br.com.souza.kotlin.github_profile_search.handler.exceptions

class ProfileNotSavedException : CustomException {

    constructor(): super("Profile not found in database.")
    constructor(message: String): super("Profile not found in database: $message")
}