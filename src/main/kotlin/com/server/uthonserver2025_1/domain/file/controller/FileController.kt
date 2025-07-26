package com.server.uthonserver2025_1.domain.file.controller

import com.server.uthonserver2025_1.domain.file.service.FileService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/file")
@Tag(name = "File")
class FileController(
    private val fileService: FileService
) {
    @PostMapping("/upload", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @Operation(summary = "Uploads files")
    fun uploadFile(@RequestParam("file") file: MultipartFile) = fileService.uploadFile(file)
}