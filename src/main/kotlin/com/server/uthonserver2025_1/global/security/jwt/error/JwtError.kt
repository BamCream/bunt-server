package com.server.uthonserver2025_1.global.security.jwt.error

import com.server.uthonserver2025_1.global.exception.CustomError
import org.springframework.http.HttpStatus

enum class JwtError(
    override val status : HttpStatus,
    override val message: String
) : CustomError {
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Token is invalid"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "Token is expired.");
}