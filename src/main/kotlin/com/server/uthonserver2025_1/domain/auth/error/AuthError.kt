package com.server.uthonserver2025_1.domain.auth.error

import com.server.uthonserver2025_1.global.exception.CustomError
import org.springframework.http.HttpStatus

enum class AuthError(
    override val status: HttpStatus,
    override val message: String,
) : CustomError {
    PASSWORD_WRONG(HttpStatus.BAD_REQUEST, "Password does not match request"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    USERNAME_ALREADY_IN_USE(HttpStatus.FORBIDDEN, "Username already in use"),
}
