package com.server.uthonserver2025_1.domain.dictionary.controller

import com.server.uthonserver2025_1.domain.dictionary.domain.entity.DictEntity
import com.server.uthonserver2025_1.domain.dictionary.dto.request.DictRequest
import com.server.uthonserver2025_1.domain.dictionary.dto.request.UnlockDictRequest
import com.server.uthonserver2025_1.domain.dictionary.service.DictService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dict")
@Tag(name = "DICTIONARY API")
class DictController(
    val dictService: DictService
) {
    @PostMapping
    @Operation(summary = "Create Dictionary")
    fun createDictionary(@RequestBody request: DictRequest) {
        dictService.addDict(request)
    }

    @PutMapping
    @Operation(summary = "update status")
    fun unlockDictionary(@RequestBody request: UnlockDictRequest) {
        dictService.unlockDict(request)
    }

    @GetMapping
    @Operation(summary = "Get All dictionary")
    fun getAllDictionary(): List<DictEntity> {
        return dictService.getAllDict()
    }

    @GetMapping("/{dictId}")
    @Operation(summary = "Get Dictionary")
    fun getDictionary(@PathVariable dictId: Long): DictEntity {
        return dictService.getDict(dictId)
    }
}