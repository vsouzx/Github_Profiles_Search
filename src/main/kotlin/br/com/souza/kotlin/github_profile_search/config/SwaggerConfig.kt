package br.com.souza.kotlin.github_profile_search.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun myOpenAPI(): OpenAPI {

        val contact = Contact()
        contact.email = "vtsoliveira2001@gmail.com"
        contact.name = "Vitor Souza Oliveira"
        contact.url = "https://vsportfolio.com.br"

        val info = Info()
        info.title = "Github Profiles Search"
        info.version = "1.0"
        info.description = "REST API to search and favorite github profiles"
        info.contact = contact

        return OpenAPI()
            .info(info)
    }
}