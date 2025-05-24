package com.faiyaz.dummy_news_app.di

import android.app.LocaleManager
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.datastore.dataStoreFile
import androidx.room.Room
import com.faiyaz.dummy_news_app.data.NewsRepository
import com.faiyaz.dummy_news_app.database.NewsLocalDatabase
import com.faiyaz.dummy_news_app.network.NewsApiClient
import com.faiyaz.dummy_news_app.network.NetworkModule
import com.faiyaz.dummy_news_app.ui.Settings.AppSettings
import com.faiyaz.dummy_news_app.ui.Settings.setAppLocale

import io.ktor.client.HttpClient
import java.util.Locale

class AppContainer(private val context: Context) {

    private val networkModule = NetworkModule()
    private val httpClient: HttpClient = networkModule.httpClient
    private val newsApiClient = NewsApiClient(httpClient)
    //DATABASE
    private val roomDB: NewsLocalDatabase= Room.
    databaseBuilder(context.applicationContext, NewsLocalDatabase::class.java,"News-Database").
    fallbackToDestructiveMigration(true).build()
    private val newsLocalDatabase = roomDB.newsDao()

    //REPOSITORY
    val newsRepository = NewsRepository(newsApiClient,newsLocalDatabase)
    init{
        setLocale(Locale(AppSettings.getLocale().toString()))
    }
    //Localization
    // LOCALE
    fun setLocale(locale: Locale) {
        setAppLocale(context,locale.language.toString())

    }

    fun getCurrentLocale(): Locale {
        return Locale.getDefault()
    }

}
