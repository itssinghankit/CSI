package com.example.csi.modelclasses

data class Answer(
    val body: String,
    val createdAt: String,
    val full_name: String,
    val id: Int,
    val likes: Int,
    val parent_id: Int,
    val user: Int
)