package com.faiyaz.dummy_news_app.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "news")
data class News(
    @PrimaryKey val uuid: String=UUID.randomUUID().toString(),

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @ColumnInfo(name = "published_at")
    val publishedAt: String,

    @ColumnInfo(name="category")
    val category:String
)
