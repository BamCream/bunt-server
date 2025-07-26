package com.server.uthonserver2025_1.domain.ocr.entity

import java.time.LocalDate

data class TicketInfo(
    val team: String?,
    val date: LocalDate?,
    val location: String?
)

fun extractTicketInfo(text: String): TicketInfo {
    // 1. 팀 이름 후보들
    val teamCandidates = listOf(
        "기아", "타이거즈", "KIA", "삼성", "라이온즈", "한화", "이글스",
        "롯데", "자이언츠", "키움", "히어로즈", "두산", "베어스",
        "SSG", "랜더스", "LG", "트윈스", "NC", "다이노스", "KT", "위즈"
    )

    // 2. 구장 후보들
    val stadiumCandidates = listOf(
        "광주기아챔피언스필드",
        "대전한화생명이글스파크",
        "사직야구장",
        "고척스카이돔",
        "잠실야구장",
        "인천SSG랜더스필드",
        "수원KT위즈파크",
        "창원NC파크",
        "대구삼성라이온즈파크"
    )

    // 3. 날짜 추출
    val dateRegex = Regex("""(\d{4})[년.\s-]*(\d{1,2})[월.\s-]*(\d{1,2})[일.\s-]*""")
    val dateMatch = dateRegex.find(text)
    val parsedDate = dateMatch?.let {
        val (year, month, day) = it.destructured
        try {
            LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch (e: Exception) {
            null
        }
    }

    // 4. 팀 이름 추출
    val lowerText = text.lowercase()
    val matchedTeam = teamCandidates.firstOrNull { team ->
        lowerText.contains(team.lowercase())
    }

    // 5. 구장 이름 추출
    val matchedStadium = stadiumCandidates.firstOrNull { stadium ->
        lowerText.contains(stadium.lowercase())
    }

    return TicketInfo(
        team = matchedTeam,
        date = parsedDate,
        location = matchedStadium
    )
}
