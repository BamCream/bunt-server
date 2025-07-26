package com.server.uthonserver2025_1.domain.user.service

import com.server.uthonserver2025_1.domain.record.domain.entity.RecordEntity
import com.server.uthonserver2025_1.domain.record.domain.enums.GameResult
import com.server.uthonserver2025_1.domain.record.domain.repository.RecordRepository
import org.springframework.stereotype.Service

@Service
class RecordService(
    private val recordRepository: RecordRepository
) {
    fun getAllRecords(): List<RecordEntity> {
        return recordRepository.findAll()
    }

    fun getGamesCount(): Int {
        return recordRepository.findAll().size
    }

    fun getWinCount(): Int {
        return recordRepository.findAll().count { it.result == GameResult.WIN }
    }

    fun getDrawCount(): Int {
        return recordRepository.findAll().count { it.result == GameResult.DRAW }
    }

    fun getLoseCount(): Int {
        return recordRepository.findAll().count { it.result == GameResult.LOSE }
    }

    fun getWinRate(): Double {
        return getWinCount().toDouble() / getGamesCount()
    }
}