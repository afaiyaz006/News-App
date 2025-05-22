package com.faiyaz.dummy_news_app.ui.NewsSearch

import NewsUIViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsGallery
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsGalleryFeatured
import com.faiyaz.dummy_news_app.ui.components.NewsCard
import com.faiyaz.dummy_news_app.ui.components.NewsHeader
import com.faiyaz.dummy_news_app.ui.components.NewsTopicSelector
import com.faiyaz.dummy_news_app.ui.components.SearchBar

@Composable
fun NewsSearchUI(
    newsSearchViewModel: NewsSearchViewModel,
    onSearchItemTapped: (news:News)->Unit={}
){
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val newsSearchUIState by newsSearchViewModel.uiState.collectAsStateWithLifecycle()
    Column(modifier = Modifier.fillMaxHeight()){
        SearchBar(
            query = searchQuery,
            onSearch = {
                newsSearchViewModel.searchNews(searchQuery)
            } ,
            onQueryChange = { newQuery -> searchQuery=newQuery}
        )
        NewsList(newsSearchUIState.newsList,onItemTapped=onSearchItemTapped)

    }
}
@Composable
fun NewsList(
    newsList:List<News>?,
    onItemTapped:(news:News)->Unit={}
){
    LazyColumn {
        items(newsList?:emptyList()){
            news -> NewsCard(
                title = news.title,
                description = news.description,
                imageUrl = news.imageUrl,
                dateString = news.publishedAt,
                onNewsCardTap = {onItemTapped(news)}
            )
        }
    }
}
//@Preview
//@Composable
//fun NewsSearchPreview(){
//    NewsSearchUI()
//}