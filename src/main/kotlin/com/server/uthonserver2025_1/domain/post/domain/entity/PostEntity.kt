package com.server.uthonserver2025_1.domain.post.domain.entity

import com.server.uthonserver2025_1.domain.tag.domain.entity.TagEntity
import com.server.uthonserver2025_1.global.common.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "posts")
data class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String = "",
    val content: String = "",
    val imageUrl: String = "",
    val authorId: Long = 0L,
    @ElementCollection
    val tags: List<String> = listOf(),

    ): BaseTimeEntity()
