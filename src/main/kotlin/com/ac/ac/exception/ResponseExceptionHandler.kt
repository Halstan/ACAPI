package com.ac.ac.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

class ResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun allExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        val er = ExceptionResponse(LocalDateTime.now(), ex.message, request.getDescription(false))
        return ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}