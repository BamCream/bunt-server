package com.server.uthonserver2025_1.domain.post.dto.request

data class PostRequest(
    val title: String,
    val content: String,
    val imageUrl: String,
    val tags: List<String>,
)