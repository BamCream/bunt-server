package com.server.uthonserver2025_1.domain.record.domain.repository

import com.server.uthonserver2025_1.domain.record.domain.entity.RecordEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : JpaRepository<RecordEntity, Long> {
}