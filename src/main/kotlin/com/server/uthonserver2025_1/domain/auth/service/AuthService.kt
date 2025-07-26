package com.server.uthonserver2025_1.domain.auth.service

import com.server.uthonserver2025_1.domain.auth.request.LoginRequest
import com.server.uthonserver2025_1.domain.auth.request.SignUpRequest
import com.server.uthonserver2025_1.domain.auth.error.AuthError
import com.server.uthonserver2025_1.domain.auth.repository.RefreshTokenRepository
import com.server.uthonserver2025_1.domain.user.domain.entity.UserEntity
import com.server.uthonserver2025_1.domain.user.domain.repository.UserRepository
import com.server.uthonserver2025_1.global.exception.CustomException
import com.server.uthonserver2025_1.global.security.jwt.provider.Jwt
import com.server.uthonserver2025_1.global.security.jwt.provider.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional
class AuthService(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder,
) {
    fun signup(request: SignUpRequest) {
        if (userRepository.existsByUsername(request.username))
            throw CustomException(AuthError.USERNAME_ALREADY_IN_USE)

        userRepository.save(
            UserEntity(
                username = request.username ,
                password = passwordEncoder.encode(request.password)
            )
        )
    }

    fun login(request: LoginRequest): Jwt {
        val user = userRepository.findByUsername(request.username) ?: throw CustomException(AuthError.USER_NOT_FOUND)

        if (!passwordEncoder.matches(request.password, user.password)) throw CustomException(AuthError.PASSWORD_WRONG)

        val tokens = jwtProvider.generateToken(user)

        userRepository.save(user.copy(lastLoginAt = LocalDateTime.now()))
        refreshTokenRepository.save(user.username, tokens.refreshToken)

        return tokens
    }
}