package com.server.uthonserver2025_1.domain.dictionary.domain.repository

import com.server.uthonserver2025_1.domain.dictionary.domain.entity.DictEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DictRepository: JpaRepository<DictEntity, Long> {
}