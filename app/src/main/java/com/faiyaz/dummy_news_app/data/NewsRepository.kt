package com.faiyaz.dummy_news_app.data

import com.faiyaz.dummy_news_app.network.NewsApiClient
import com.faiyaz.dummy_news_app.data.News

class NewsRepository(
    private val apiClient: NewsApiClient
) {
    suspend fun getFeatureWiseNews(category: String): List<News>? {

        return apiClient.getCategoricalNews(category)
    }

    suspend fun getTopNews(): List<News>? {
        return apiClient.getTopNews()
    }
}
