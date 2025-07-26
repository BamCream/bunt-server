package com.server.uthonserver2025_1.domain.file.service

import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun uploadFile(file: MultipartFile): String
}