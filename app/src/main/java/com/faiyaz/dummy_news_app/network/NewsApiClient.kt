package com.faiyaz.dummy_news_app.network

import android.util.Log
import com.faiyaz.dummy_news_app.BuildConfig
import com.faiyaz.dummy_news_app.data.News
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.util.Locale
class NewsApiClient(
    private val httpClient: HttpClient
){
    private val apiKey = BuildConfig.NEWS_API_KEY
    suspend fun getNewsData(endpoint:String,topic:String="top"):List<News>?{
        var response = httpClient.get(endpoint)
        var responseString = response.bodyAsText()

        val jsonElement = Json.parseToJsonElement(responseString)
        val jsonArticles = jsonElement.jsonObject["articles"]
        var newsList:List<News>?=jsonArticles?.jsonArray?.mapNotNull{

            News(
                author = it.jsonObject["author"]?.jsonPrimitive?.contentOrNull.toString(),
                title=it.jsonObject["title"]?.jsonPrimitive?.contentOrNull.toString(),
                content=it.jsonObject["content"]?.jsonPrimitive?.contentOrNull.toString(),
                description = it.jsonObject["description"]?.jsonPrimitive?.contentOrNull.toString(),
                url=it.jsonObject["url"]?.jsonPrimitive?.contentOrNull.toString(),
                imageUrl = it.jsonObject["urlToImage"]?.jsonPrimitive?.contentOrNull.toString(),
                publishedAt = it.jsonObject["publishedAt"]?.jsonPrimitive?.contentOrNull.toString(),
                category= topic.toString().lowercase()

            )

        }
        Log.d("json",response.toString())
        return newsList
    }

    suspend fun getCategoricalNews(topic:String):List<News>?{
        try {
            val endpoint =
                "https://newsapi.org/v2/top-headlines?&category=$topic&apiKey=$apiKey"
            val newsList = getNewsData(endpoint, topic)
            return newsList
        }catch(e: Exception){
            return emptyList()
        }
    }
    suspend fun getTopNews():List<News>?{
        try {
            val endpoint = "https://newsapi.org/v2/top-headlines?&apiKey=$apiKey"
            return getNewsData(endpoint)
        }catch(e: Exception){
            return emptyList()
        }
    }

    suspend fun searchNews(queryString:String):List<News>?{
        try {
            val endpoint =
                "https://newsapi.org/v2/everything?q=$queryString&from=2025-05-01&sortBy=popularity&apiKey=$apiKey"

            return getNewsData(endpoint, "searched")
        }catch (e: Exception){
            return emptyList()
        }
    }
}