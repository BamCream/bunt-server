package com.server.uthonserver2025_1.domain.ocr.service

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.FileSystemResource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.function.RequestPredicates.contentType
import java.io.File
import java.net.http.HttpHeaders

@Service
class OcrSpaceService(private val restTemplate: RestTemplate = RestTemplate()) {

    fun extractTextFromImage(imageFile: File): String {
        val headers = org.springframework.http.HttpHeaders().apply {
            contentType = MediaType.MULTIPART_FORM_DATA
            set("apikey", "K82594601888957")
        }

        val body = LinkedMultiValueMap<String, Any>().apply {
            add("language", "kor")
            add("isOverlayRequired", "false")
            add("file", FileSystemResource(imageFile))
        }

        val request = HttpEntity(body, headers)

        val response = restTemplate.postForEntity(
            "https://api.ocr.space/parse/image",
            request,
            String::class.java
        )

        val json = ObjectMapper().readTree(response.body)
        return json["ParsedResults"]?.get(0)?.get("ParsedText")?.asText() ?: ""
    }
}