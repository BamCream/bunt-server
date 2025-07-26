package com.server.uthonserver2025_1.domain.auth.repository


interface RefreshTokenRepository {
    fun save(email: String, refreshToken: String)
    fun findByEmail(email: String): String?
    fun deleteByEmail(email: String): Boolean
    fun existsByEmail(email: String): Boolean
}