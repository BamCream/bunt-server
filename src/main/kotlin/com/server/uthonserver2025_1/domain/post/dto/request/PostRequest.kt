package com.server.uthonserver2025_1.domain.post.dto.request

import com.server.uthonserver2025_1.domain.tag.dto.request.TagRequest

data class PostRequest(
    val title: String,
    val content: String,
    val imageUrl: String,
    val tags: List<TagRequest>,
)