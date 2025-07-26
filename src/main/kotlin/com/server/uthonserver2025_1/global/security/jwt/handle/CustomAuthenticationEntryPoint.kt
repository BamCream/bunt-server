package com.server.uthonserver2025_1.global.security.jwt.handle

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "UTF-8"

        val jsonResponse = """
            {
                "status": 401,
                "error": "Unauthorized",
                "message": "Need Account",
                "path": "${request.requestURI}"
            }
        """
            .trimIndent()

        response.writer.write(jsonResponse)
        response.writer.flush()
    }
}