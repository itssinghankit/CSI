package com.example.csi.modelclasses

data class Question(
    val body: String,
    val createdAt: String,
    val full_name: String,
    val id: Int,
    val tech: String,
    val user: Int
)