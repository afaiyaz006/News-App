package com.faiyaz.dummy_news_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.faiyaz.dummy_news_app.data.News

@Dao
interface NewsDAO{
    @Query("Select * FROM news WHERE category==:category")
    suspend fun getAll(category:String): List<News>

    @Insert
    suspend fun insertAll(news: List<News>)

    @Query("""
    SELECT * FROM news 
    WHERE 
    title LIKE '%' || :query || '%' OR 
    content LIKE '%' || :query || '%' OR 
    author LIKE '%' || :query || '%' OR 
    description LIKE '%' || :query || '%'
""")
    suspend fun searchNews(query: String): List<News>
}