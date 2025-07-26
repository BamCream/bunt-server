package com.server.uthonserver2025_1.domain.ocr.response

import java.time.LocalDate

data class TicketInfo(
    val team: String?,
    val date: LocalDate?,
    val location: String?
)
