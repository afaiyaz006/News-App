package com.faiyaz.dummy_news_app.ui.Favourites


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.ui.components.NewsCard
import com.faiyaz.dummy_news_app.ui.components.SearchBar

@Composable
fun FavouritesUI(
    favouriteNews:List<News>?,
    onLikeButtonClicked: (News)->Unit={}
){
    Column(modifier = Modifier.fillMaxHeight()){
        NewsList(
            favNews=favouriteNews,
            onLikeButtonClicked=onLikeButtonClicked
        )

    }
}
@Composable
fun NewsList(favNews:List<News>?=null,onLikeButtonClicked: (News) -> Unit){
    LazyColumn {
        items(favNews?:emptyList()){
            news ->
            NewsCard(
                title = news.title,
                description = news.description,
                imageUrl = news.imageUrl,
                dateString = news.publishedAt,
                isLiked = news.liked,
                onLikeButtonTap ={onLikeButtonClicked(news)}
            )
        }
    }
}
//@Preview
//@Composable
//fun NewsSearchPreview(){
//    FavouritesUI()
//}