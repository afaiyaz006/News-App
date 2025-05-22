package com.faiyaz.dummy_news_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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


    @Query("UPDATE news SET isLiked = 1 WHERE uuid = :uuid")
    suspend fun likeNewsByUuid(uuid: String)

    @Query("UPDATE news SET isLiked = 0 WHERE uuid = :uuid")
    suspend fun unlikeNewsByUuid(uuid: String)


    @Query("SELECT * FROM news WHERE isLiked = 1")
    suspend fun getLikedNews(): List<News>
}