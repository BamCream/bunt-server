package com.server.uthonserver2025_1.global.exception

import org.springframework.http.HttpStatus

interface CustomError {
    val status: HttpStatus
    val message: String
}