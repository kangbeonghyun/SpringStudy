package com.kotlinspring.dto

data class CourseDTO(
    val id: Int?, //DB AI 값이라 널러블
    val name :String,
    val category: String
)