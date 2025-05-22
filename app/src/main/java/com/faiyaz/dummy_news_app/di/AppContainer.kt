package com.faiyaz.dummy_news_app.di

import android.content.Context
import androidx.room.Room
import com.faiyaz.dummy_news_app.data.NewsRepository
import com.faiyaz.dummy_news_app.database.NewsLocalDatabase
import com.faiyaz.dummy_news_app.network.NewsApiClient
import com.faiyaz.dummy_news_app.network.NetworkModule
import io.ktor.client.HttpClient

class AppContainer(context: Context) {

    private val networkModule = NetworkModule()
    private val httpClient: HttpClient = networkModule.httpClient
    private val newsApiClient = NewsApiClient(httpClient)
    private val roomDB= Room.databaseBuilder(context, NewsLocalDatabase::class.java,"News-Database-v1").build()
    private val newsLocalDatabase = roomDB.newsDao()
    val newsRepository = NewsRepository(newsApiClient,newsLocalDatabase)

}
