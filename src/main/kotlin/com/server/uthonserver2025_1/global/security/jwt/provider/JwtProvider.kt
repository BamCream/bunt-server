package com.server.uthonserver2025_1.global.security.jwt.provider

import com.server.uthonserver2025_1.domain.auth.error.AuthError
import com.server.uthonserver2025_1.domain.user.domain.entity.UserEntity
import com.server.uthonserver2025_1.global.exception.CustomException
import com.server.uthonserver2025_1.global.security.jwt.property.JwtProperties
import com.server.uthonserver2025_1.global.security.jwt.enums.JwtType
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val userDetailsService: UserDetailsService,
) {
    private val key: SecretKey by lazy {
        SecretKeySpec(
            jwtProperties.secretKey.toByteArray(StandardCharsets.UTF_8),
            Jwts.SIG.HS512.key().build().algorithm
        )
    }

    fun getUserId(token: String): String {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .body
            .subject
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getType(token: String): JwtType {
        val jws = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)

        val type = jws.header["typ"] as String
        return JwtType.valueOf(type)
    }

    fun generateToken(user: UserEntity): Jwt {
        val now = Date()
        val accessToken = Jwts.builder()
            .header()
            .type(JwtType.ACCESS.name)
            .and()
            .subject(user.username)
            .signWith(key)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + jwtProperties.accessTokenExpiration))
            .compact()
        val refreshToken = Jwts.builder()
            .header()
            .type(JwtType.REFRESH.name)
            .and()
            .subject(user.username)
            .signWith(key)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + jwtProperties.accessTokenExpiration))
            .compact()

        return Jwt(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun getAuthentication(token: String): Authentication {
        val userId = getUserId(token)
        return try {
            val userDetails = userDetailsService.loadUserByUsername(userId)
            UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        } catch (e: Exception) {
            throw CustomException(AuthError.USER_NOT_FOUND)
        }
    }

    fun extractToken(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization")
        return if (token != null && token.startsWith("Bearer ")) {
            token.substring(7)
        } else null
    }
}

data class Jwt(
    val accessToken: String,
    val refreshToken: String
)