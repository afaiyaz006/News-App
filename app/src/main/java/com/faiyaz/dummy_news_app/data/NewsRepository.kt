package com.faiyaz.dummy_news_app.data

import android.util.Log
import com.faiyaz.dummy_news_app.network.NewsApiClient
import com.faiyaz.dummy_news_app.database.NewsDAO

class NewsRepository(
    private val apiClient: NewsApiClient,
    private val newsLocalDatabase: NewsDAO
) {
    suspend fun getFeatureWiseNews(category: String): List<News>? {

        var newNewsList:List<News>? = apiClient.getCategoricalNews(category)
        newsLocalDatabase.insertAll(newNewsList?:emptyList())
        var newsList:List<News>? = newsLocalDatabase.getAll(category)
        return newsList

    }

    suspend fun getTopNews(): List<News>? {
        var newNewsList:List<News>?=apiClient.getTopNews()
        newsLocalDatabase.insertAll(newNewsList?:emptyList())
        var newsList:List<News>? = newsLocalDatabase.getAll("top")
        return newsList
    }

    suspend fun searchNews(query:String):List<News>?{
        var results:List<News>? = newsLocalDatabase.searchNews(query)
        if(results?.isEmpty()==true){
            results = apiClient.searchNews(query)
            newsLocalDatabase.insertAll(results?:emptyList())
        }
        return results
    }
}
