package com.server.uthonserver2025_1.global.security.holder.impl

import com.server.uthonserver2025_1.domain.user.domain.entity.UserEntity
import com.server.uthonserver2025_1.domain.user.domain.repository.UserRepository
import com.server.uthonserver2025_1.global.security.holder.SecurityHolder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityHolderImpl(
    private val userRepository: UserRepository
) : SecurityHolder {
    override fun getPrincipal(): UserEntity? {
        val authentication = SecurityContextHolder.getContext().authentication ?: return null
        val principal = authentication.principal
        val email = when (principal) {
            is String -> principal
            is org.springframework.security.core.userdetails.UserDetails -> principal.username
            else -> null
        } ?: return null

        return userRepository.findByEmail(email)
    }
}