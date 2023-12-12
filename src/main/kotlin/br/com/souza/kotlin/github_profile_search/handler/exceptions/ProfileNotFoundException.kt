package br.com.souza.kotlin.github_profile_search.handler.exceptions

class ProfileNotFoundException : CustomException {

    constructor(): super("Github profile not found.")
    constructor(message: String): super("Github profile not found: $message")
}