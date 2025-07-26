package com.server.uthonserver2025_1.domain.auth.request

import jakarta.validation.constraints.Email

data class SignUpRequest(
    @Email(message = "not email form")
    val email: String,
    val username: String,
    val password: String
)
