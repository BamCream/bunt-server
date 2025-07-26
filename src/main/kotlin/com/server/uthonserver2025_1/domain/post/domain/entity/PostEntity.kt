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
    val likeCount: Long = 0L,
    @ManyToMany
    @JoinTable(name = "tags")
    val tags: List<TagEntity> = listOf(),

    ): BaseTimeEntity()
