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

    override fun save(username: String, refreshToken: String) {
        val key = "refreshToken:$username"
        redisTemplate.opsForValue()
            .set(key, refreshToken, Duration.ofMillis(jwtProperties.refreshTokenExpiration))
    }

    override fun findByUsername(username: String): String? {
        val key = "refreshToken:$username"
        return redisTemplate.opsForValue().get(key)
    }

    override fun deleteByUsername(username: String): Boolean {
        val key = "refreshToken:$username"
        return redisTemplate.delete(key)
    }


    override fun existsByUsername(username: String): Boolean {
        val key = "refreshToken:$username"
        return redisTemplate.hasKey(key)
    }
}