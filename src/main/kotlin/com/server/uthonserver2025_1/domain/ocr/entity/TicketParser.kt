package com.server.uthonserver2025_1.domain.ocr.entity

import java.time.LocalDate

object TicketParser {
    private val teamKeywords = listOf(
        "기아", "타이거즈", "KIA", "삼성", "라이온즈", "한화", "이글스",
        "롯데", "자이언츠", "키움", "히어로즈", "두산", "베어스",
        "SSG", "랜더스", "LG", "트윈스", "NC", "다이노스", "KT", "위즈"
    )

    private val stadiumKeywords = listOf(
        "광주기아챔피언스필드", "대전한화생명이글스파크", "사직야구장", "고척스카이돔",
        "잠실야구장", "인천SSG랜더스필드", "수원KT위즈파크", "창원NC파크", "대구삼성라이온즈파크"
    )

    fun parse(text: String): TicketInfo {
        val team = teamKeywords.firstOrNull { keyword ->
            text.contains(keyword, ignoreCase = true)
        }

        val dateRegex = Regex("""(\d{4})[년.\s-]*(\d{1,2})[월.\s-]*(\d{1,2})[일.\s-]*""")
        val dateMatch = dateRegex.find(text)
        val date = dateMatch?.let {
            val (year, month, day) = it.destructured
            try {
                LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            } catch (e: Exception) {
                null
            }
        }

        val location = stadiumKeywords.firstOrNull { stadium ->
            text.contains(stadium, ignoreCase = true)
        }

        return TicketInfo(team = team, date = date, location = location)
    }
}