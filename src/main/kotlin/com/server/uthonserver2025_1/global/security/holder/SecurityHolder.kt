package com.server.uthonserver2025_1.global.security.holder

import com.server.uthonserver2025_1.domain.user.domain.entity.UserEntity


interface SecurityHolder {
    fun getPrincipal(): UserEntity?
}