package com.server.uthonserver2025_1.domain.record.domain.entity

import com.server.uthonserver2025_1.domain.record.domain.enums.GameResult
import com.server.uthonserver2025_1.global.common.entity.BaseTimeEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "records")
data class RecordEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val homeTeam: String,
    val awayTeam: String,
    val matchDate: LocalDateTime,
    val field: String,
    val result: GameResult
): BaseTimeEntity()