package com.example.finschoolapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: Int,
    val title: String,
    val content: String,
    val moduleId: Int
)