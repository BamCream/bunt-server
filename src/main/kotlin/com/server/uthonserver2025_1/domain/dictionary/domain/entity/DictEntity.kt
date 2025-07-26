package com.server.uthonserver2025_1.domain.dictionary.domain.entity

import com.server.uthonserver2025_1.domain.dictionary.domain.enums.DictStatus
import jakarta.persistence.*

@Entity
@Table(name = "dicts")
data class DictEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val productUrl: String = "",
    val productName: String = "",
    val productImage: String = "",
    @ElementCollection
    val serials: List<String> = listOf(),
    @Enumerated(EnumType.STRING)
    val isUnlocked: DictStatus = DictStatus.LOCKED
    )
