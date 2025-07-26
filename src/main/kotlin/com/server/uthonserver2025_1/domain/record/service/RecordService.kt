package com.server.uthonserver2025_1.domain.record.service

import com.server.uthonserver2025_1.domain.record.domain.entity.RecordEntity
import com.server.uthonserver2025_1.domain.record.domain.enums.GameResult
import com.server.uthonserver2025_1.domain.record.domain.repository.RecordRepository
import com.server.uthonserver2025_1.domain.record.dto.response.AllRecords
import org.springframework.stereotype.Service

@Service
class RecordService(
    private val recordRepository: RecordRepository
) {
    fun getAll(): AllRecords {
        return AllRecords(
            recordRepository.findAll(),
            recordRepository.findAll().size,
            recordRepository.findAll().count { it.result == GameResult.WIN },
            recordRepository.findAll().count { it.result == GameResult.DRAW },
            recordRepository.findAll().count { it.result == GameResult.LOSE },
            getWinCount().toDouble() / getGamesCount())
    }

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