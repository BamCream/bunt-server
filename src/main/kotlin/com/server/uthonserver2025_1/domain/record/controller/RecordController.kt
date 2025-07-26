package com.server.uthonserver2025_1.domain.record.controller

import com.server.uthonserver2025_1.domain.record.service.RecordService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
@Tag(name = "Record")
class RecordController(
    val recordService: RecordService
) {
    @GetMapping
    @Operation(summary = "짬뽕")
    fun getRecords() = recordService.getAll()

    @Operation(summary = "모든 경기 리스트 조회")
    @GetMapping("/all")
    fun getAllRecords() = recordService.getAllRecords()

    @Operation(summary = "총 경기수 조회")
    @GetMapping("/games-count")
    fun getGamesCount() = recordService.getGamesCount()

    @Operation(summary = "승리 게임 수 조회")
    @GetMapping("/win-count")
    fun getWinCount() = recordService.getWinCount()

    @Operation(summary = "패배 게임 수 조회")
    @GetMapping("/lose-count")
    fun getLoseCount() = recordService.getLoseCount()

    @Operation(summary = "무승부 게임 수 조회")
    @GetMapping("/draw-count")
    fun getDrawCount() = recordService.getDrawCount()

    @Operation(summary = "승률 조회")
    @GetMapping("/win-rate")
    fun getWinRate() = recordService.getWinRate()
}