package br.com.souza.kotlin.github_profile_search.handler

import br.com.souza.kotlin.github_profile_search.dto.CustomErrorResponse
import br.com.souza.kotlin.github_profile_search.handler.exceptions.CustomException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(CustomException::class)
    fun handleCustomError(e: Exception, request: WebRequest): ResponseEntity<Any>? {

        val errorResponse = CustomErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            error = e.message
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        return handleExceptionInternal(e, errorResponse, headers, HttpStatus.BAD_REQUEST, request)
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralError(e: Exception, request: WebRequest): ResponseEntity<Any>? {

        val errorResponse = CustomErrorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = e.message
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        return handleExceptionInternal(e, errorResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR, request)
    }
}