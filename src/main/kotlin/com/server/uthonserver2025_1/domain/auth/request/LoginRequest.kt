package com.server.uthonserver2025_1.domain.auth.request

import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @NotBlank(message = "username required")
    val username: String,

    @NotBlank(message = "password required")
    val password: String
)
