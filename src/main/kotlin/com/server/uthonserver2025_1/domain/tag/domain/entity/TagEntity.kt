package com.server.uthonserver2025_1.domain.tag.domain.entity

import com.server.uthonserver2025_1.domain.post.domain.entity.PostEntity
import jakarta.persistence.*
import org.springframework.boot.context.properties.bind.ConstructorBinding

@Entity
@Table(name = "tags")
data class TagEntity @ConstructorBinding constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String = "",
    val count: Long = 0L,

    @ManyToMany
    @JoinTable(name = "posts")
    val posts: List<PostEntity> = listOf()
)
