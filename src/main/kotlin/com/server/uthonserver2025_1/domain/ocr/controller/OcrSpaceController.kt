package com.server.uthonserver2025_1.domain.ocr.controller

import com.server.uthonserver2025_1.domain.ocr.entity.TicketInfo
import com.server.uthonserver2025_1.domain.ocr.entity.TicketParser
import com.server.uthonserver2025_1.domain.ocr.service.OcrSpaceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("/ocr")
class OcrController(
    private val ocrService: OcrSpaceService
) {

    @PostMapping("/parse")
    fun parseTicketInfo(@RequestParam("image") image: MultipartFile): ResponseEntity<TicketInfo> {
        // 1. 업로드된 파일을 임시파일로 저장
        val tempFile = File.createTempFile("upload-", ".jpg")
        image.transferTo(tempFile)

        // 2. OCR 통해 텍스트 추출
        val extractedText = ocrService.extractTextFromImage(tempFile)
        tempFile.delete()

        // 3. 추출된 텍스트에서 팀/날짜 파싱
        val info = TicketParser.parse(extractedText)

        return ResponseEntity.ok(info)
    }
}