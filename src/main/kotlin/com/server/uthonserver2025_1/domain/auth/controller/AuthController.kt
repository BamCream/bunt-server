package com.server.uthonserver2025_1.domain.auth.controller

import com.server.uthonserver2025_1.domain.auth.request.LoginRequest
import com.server.uthonserver2025_1.domain.auth.request.SignUpRequest
import com.server.uthonserver2025_1.domain.auth.service.AuthService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
class AuthController(
    val authService: AuthService
) {
    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: SignUpRequest) = authService.signup(request)

    @Operation(summary = "로그인")
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: LoginRequest) = authService.login(request)
}