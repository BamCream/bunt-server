package com.server.uthonserver2025_1.domain.record.dto.response

data class AllRecords(
    val gamesCount: Int,
    val winCount: Int,
    val drawCount: Int,
    val loseCount: Int,
    var winRate: Double,
)