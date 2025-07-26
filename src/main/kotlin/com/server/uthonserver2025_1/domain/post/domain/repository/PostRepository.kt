package com.server.uthonserver2025_1.domain.post.domain.repository

import com.server.uthonserver2025_1.domain.post.domain.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<PostEntity, Long> {
}