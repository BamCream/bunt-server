package com.server.uthonserver2025_1.global.security.jwt.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties @ConstructorBinding constructor (
    val secretKey: String,
    val accessTokenExpiration: Long,
    val refreshTokenExpiration: Long
)