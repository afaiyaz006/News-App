package com.faiyaz.dummy_news_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faiyaz.dummy_news_app.data.News

@Database(entities = [News::class], version = 1)
abstract class NewsLocalDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDAO
}