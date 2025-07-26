package com.server.uthonserver2025_1.domain.record.dto.response

import com.server.uthonserver2025_1.domain.record.domain.entity.RecordEntity

data class AllRecords(
    val allRecords: List<RecordEntity>,
    val gamesCount: Int,
    val winCount: Int,
    val drawCount: Int,
    val loseCount: Int,
    var winRate: Double,
)