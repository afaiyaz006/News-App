package com.faiyaz.dummy_news_app.data

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val author: String,
    val title:String,
    val description:String,
    val content:String,
    val url:String,
    val imageUrl:String,
    val publishedAt:String,
)
