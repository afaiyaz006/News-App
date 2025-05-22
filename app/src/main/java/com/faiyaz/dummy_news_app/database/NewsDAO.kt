package com.faiyaz.dummy_news_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.faiyaz.dummy_news_app.data.News

@Dao
interface NewsDAO{
    @Query("Select * FROM news WHERE category==(:category)")
    fun getAll(category:String): List<News>

    @Insert
    fun insertAll(news: List<News>)
}