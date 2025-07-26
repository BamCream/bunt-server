package com.server.uthonserver2025_1.domain.auth.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @Email(message = "not email form")
    @NotBlank(message = "email required")
    val email: String,

    @NotBlank(message = "password required")
    val password: String
)
