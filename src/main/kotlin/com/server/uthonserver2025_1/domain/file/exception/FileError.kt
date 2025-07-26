package com.server.uthonserver2025_1.domain.file.exception

import com.server.uthonserver2025_1.global.exception.CustomError
import org.springframework.http.HttpStatus

enum class FileError(
    override val status: HttpStatus,
    override val message: String,
): CustomError {
    FILE_UPLOAD_FAIL(HttpStatus.BAD_REQUEST, "failed to upload file")
}