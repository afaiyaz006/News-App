package com.faiyaz.dummy_news_app.data.utils

enum class NewsCategory(val value: String) {
    BUSINESS("business"),
    ENTERTAINMENT("entertainment"),
    GENERAL("general"),
    HEALTH("health"),
    SCIENCE("science"),
    SPORTS("sports"),
    TECHNOLOGY("technology");

    companion object {
        fun fromValue(value: String): NewsCategory? {
            return NewsCategory.entries.find { it.value.equals(value, ignoreCase = true) }
        }

        fun getAllValues(): List<String> = NewsCategory.entries.map { it.value }
    }
}
