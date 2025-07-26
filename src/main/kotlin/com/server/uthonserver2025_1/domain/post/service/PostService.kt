package com.server.uthonserver2025_1.domain.post.service

import com.server.uthonserver2025_1.domain.post.domain.entity.PostEntity
import com.server.uthonserver2025_1.domain.post.domain.repository.PostRepository
import com.server.uthonserver2025_1.domain.post.dto.request.PostRequest
import com.server.uthonserver2025_1.domain.user.domain.repository.UserRepository
import com.server.uthonserver2025_1.global.security.holder.SecurityHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostService(
    private val postRepository: PostRepository,
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
                tags = request.tags
            )
        )
    }

    fun getPost(postId: Long): PostEntity {
        return postRepository.findById(postId).get()
    }

    fun getAllPosts(): List<PostEntity> {
        return postRepository.findAll().toList()
    }
}
