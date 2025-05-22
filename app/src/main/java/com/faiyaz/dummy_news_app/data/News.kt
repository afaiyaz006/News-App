package com.faiyaz.dummy_news_app.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "news")
data class News(
    @PrimaryKey val uuid: String=UUID.randomUUID().toString(),

    @ColumnInfo(name = "author")
    val author: String? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "content")
    val content: String? = null,

    @ColumnInfo(name = "url")
    val url: String? = null,

    @ColumnInfo(name = "image_url")
    val imageUrl: String? = null,

    @ColumnInfo(name = "published_at")
    val publishedAt: String? = null,

    @ColumnInfo(name="category")
    val category:String? = null
)
