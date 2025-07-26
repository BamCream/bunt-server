package com.server.uthonserver2025_1.domain.post.domain.enums

import com.server.uthonserver2025_1.global.exception.CustomError
import org.springframework.http.HttpStatus

enum class PostError(
    override val status: HttpStatus,
    override val message: String,
): CustomError {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Not found"),
}