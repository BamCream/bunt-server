package com.server.uthonserver2025_1.domain.dictionary.dto.request

data class DictRequest(
    val productUrl: String,
    val productName: String,
    val productImage: String,
    val serials: List<String>
)
