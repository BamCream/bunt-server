package com.server.uthonserver2025_1.domain.tag.domain.repository

import com.server.uthonserver2025_1.domain.tag.domain.entity.TagEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<TagEntity, Long> {
    fun existsByName(name: String): Boolean
    fun findByName(name: String): TagEntity
}