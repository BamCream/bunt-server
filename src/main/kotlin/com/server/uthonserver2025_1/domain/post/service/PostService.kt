package com.server.uthonserver2025_1.domain.post.service

import com.server.uthonserver2025_1.domain.post.domain.entity.PostEntity
import com.server.uthonserver2025_1.domain.post.domain.repository.PostRepository
import com.server.uthonserver2025_1.domain.post.dto.request.PostRequest
import com.server.uthonserver2025_1.domain.tag.domain.entity.TagEntity
import com.server.uthonserver2025_1.domain.tag.domain.repository.TagRepository
import com.server.uthonserver2025_1.domain.tag.service.TagService
import com.server.uthonserver2025_1.domain.user.domain.repository.UserRepository
import com.server.uthonserver2025_1.global.security.holder.SecurityHolder
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
    private val tagService: TagService,
    private val userRepository: UserRepository,
    private val securityHolder: SecurityHolder
) {
    fun createPost(request: PostRequest): PostEntity {
        return postRepository.save(
            PostEntity (
                title = request.title,
                content = request.content,
                imageUrl = request.imageUrl,
                authorId = securityHolder.getPrincipal()!!.id!!,
                tags = request.tags.stream().map { it -> tagService.registerTag(it) }.toList()
            )
        )
    }
}
