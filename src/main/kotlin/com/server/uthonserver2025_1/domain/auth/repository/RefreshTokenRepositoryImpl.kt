package com.server.uthonserver2025_1.domain.auth.repository

import com.server.uthonserver2025_1.global.security.jwt.property.JwtProperties
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.time.Duration

@Repository
class RefreshTokenRepositoryImpl(
    private val jwtProperties: JwtProperties,
    private val redisTemplate: RedisTemplate<String, String>
) : RefreshTokenRepository {

    override fun save(email: String, refreshToken: String) {
        val key = "refreshToken:$email"
        redisTemplate.opsForValue()
            .set(key, refreshToken, Duration.ofMillis(jwtProperties.refreshTokenExpiration))
    }

    override fun findByEmail(email: String): String? {
        val key = "refreshToken:$email"
        return redisTemplate.opsForValue().get(key)
    }

    override fun deleteByEmail(email: String): Boolean {
        val key = "refreshToken:$email"
        return redisTemplate.delete(key)
    }


    override fun existsByEmail(email: String): Boolean {
        val key = "refreshToken:$email"
        return redisTemplate.hasKey(key)
    }
}