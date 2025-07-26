package com.server.uthonserver2025_1.global.exception


class CustomException(
    val error: CustomError
) : RuntimeException(error.message){
}