package br.com.souza.kotlin.github_profile_search

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class GithubProfileSearchApplication

fun main(args: Array<String>) {
	runApplication<GithubProfileSearchApplication>(*args)
}
