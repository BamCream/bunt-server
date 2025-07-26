package com.server.uthonserver2025_1.domain.user.domain.entity

import com.server.uthonserver2025_1.domain.user.domain.enums.UserRole
import com.server.uthonserver2025_1.global.common.entity.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val username: String,
    val password: String,
    val role: UserRole = UserRole.ROLE_USER,
    val lastLoginAt: LocalDateTime? = null
): BaseTimeEntity()