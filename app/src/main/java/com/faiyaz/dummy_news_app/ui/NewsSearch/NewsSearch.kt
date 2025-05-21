package com.faiyaz.dummy_news_app.ui.NewsSearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsGallery
import com.faiyaz.dummy_news_app.ui.NewsUI.NewsGalleryFeatured
import com.faiyaz.dummy_news_app.ui.components.NewsCard
import com.faiyaz.dummy_news_app.ui.components.NewsHeader
import com.faiyaz.dummy_news_app.ui.components.NewsTopicSelector
import com.faiyaz.dummy_news_app.ui.components.SearchBar

@Composable
fun NewsSearchUI(){
    Column(modifier = Modifier.fillMaxHeight()){
        SearchBar(
            query = "",
            onSearch = {},
            onQueryChange = {}
        )
        NewsList()

    }
}
@Composable
fun NewsList(){
    LazyColumn {
        items(10){
            NewsCard()
        }
    }
}
@Preview
@Composable
fun NewsSearchPreview(){
    NewsSearchUI()
}