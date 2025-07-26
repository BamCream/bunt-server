package com.server.uthonserver2025_1.domain.post.controller

import com.server.uthonserver2025_1.domain.post.domain.entity.PostEntity
import com.server.uthonserver2025_1.domain.post.dto.request.PostRequest
import com.server.uthonserver2025_1.domain.post.service.PostService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
@Tag(name = "POST API")
class PostController(
    private val postService: PostService
) {
    @PostMapping
    @Operation(summary = "create a new post")
    fun createPost(@RequestBody request: PostRequest): ResponseEntity<PostEntity> {
        return ResponseEntity.ok(postService.createPost(request))
    }
}