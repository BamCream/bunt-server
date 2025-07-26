package com.server.uthonserver2025_1.domain.file.service.impl

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import com.server.uthonserver2025_1.domain.file.exception.FileError
import com.server.uthonserver2025_1.domain.file.service.FileService
import com.server.uthonserver2025_1.global.exception.CustomException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
@Transactional
class FileServiceImpl(
    val amazonS3Client: AmazonS3Client,
    @Value("\${cloud.aws.bucket}")
    val bucket: String
): FileService {
    override fun uploadFile(file: MultipartFile): String {
        try {
            val fileName = "bunt/${file.originalFilename}.${file.originalFilename?.split(".")?.get(1)}"

            val metadata = ObjectMetadata().apply {
                contentType = file.contentType
                contentLength = file.size
            }

            amazonS3Client.putObject(bucket, fileName, file.inputStream, metadata)

            return amazonS3Client.getUrl(bucket, fileName).toString()
        } catch (e: Exception) {
            throw CustomException(FileError.FILE_UPLOAD_FAIL)
        }
    }
}