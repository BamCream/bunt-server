package com.server.uthonserver2025_1.domain.auth.repository


interface RefreshTokenRepository {
    fun save(username: String, refreshToken: String)
    fun findByUsername(username: String): String?
    fun deleteByUsername(username: String): Boolean
    fun existsByUsername(username: String): Boolean
}