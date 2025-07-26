package com.server.uthonserver2025_1.domain.tag.service

import com.server.uthonserver2025_1.domain.post.domain.entity.PostEntity
import com.server.uthonserver2025_1.domain.post.domain.repository.PostRepository
import com.server.uthonserver2025_1.domain.tag.domain.entity.TagEntity
import com.server.uthonserver2025_1.domain.tag.domain.repository.TagRepository
import com.server.uthonserver2025_1.domain.tag.dto.request.TagRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TagService(
    private val tagRepository: TagRepository,
    private val postRepository: PostRepository,
) {
    fun registerTag(request: TagRequest): TagEntity {
        val post: PostEntity = postRepository.findById(request.postId).get()
        if (tagRepository.existsByName(request.name)) {
            return addTag(request.name, post)
        } else {
            return tagRepository.save(
                TagEntity(
                    name = request.name,
                    count = 1,
                    posts = listOf(post)
                )
            )
        }
    }

    private fun addTag(name: String, post: PostEntity): TagEntity {
        val tag: TagEntity = tagRepository.findByName(name)
        val posts = tag.posts + post
        val updatedTag = TagEntity(
            id = tag.id,
            name = tag.name,
            count = tag.count + 1,
            posts = posts
        )
        return tagRepository.save(updatedTag)
    }
}