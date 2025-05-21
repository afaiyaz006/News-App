package com.faiyaz.dummy_news_app.ui.NewsUI

import NewsUIViewModel
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faiyaz.dummy_news_app.NewsApplication
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.ui.components.NewsCard
import com.faiyaz.dummy_news_app.ui.components.NewsHeader
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faiyaz.dummy_news_app.data.utils.NewsCategory
import com.faiyaz.dummy_news_app.ui.components.CategoryButton
import com.faiyaz.dummy_news_app.ui.components.NewsTopicSelector

@Composable
fun NewsUI(
    newsUiViewModel: NewsUIViewModel
){

    val newsViewState by newsUiViewModel.uiState.collectAsStateWithLifecycle()
    val topNews = newsViewState.topNews
    val categoryNews = newsViewState.categoryNews
    Log.d("Data",topNews.toString())
    Column(
        modifier = Modifier.fillMaxHeight().verticalScroll(rememberScrollState())
    ){
        NewsHeader()
        val categories = NewsCategory.getAllValues()

        LazyRow(
            modifier= Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories){
                    category -> CategoryButton(
                text = category.toString(),
                selected =newsViewState.selectedCategory==category.toString(),
                onClick = {

                    newsUiViewModel.updateCategory(category.toString())
                }
            )
            }
        }
        NewsGallery(categoryNews)
        NewsHeader(headerName = "Featured")
        NewsGalleryFeatured(topNews)
    }
}
@Composable
fun NewsGallery(categoryNews:List<News>){
    LazyRow {

        items(categoryNews){
            news -> NewsCard(
                        title =news.title,
                        description = news.description,
                        imageUrl = news.imageUrl
                    )
        }
    }
}
@Composable
fun NewsGalleryFeatured(topNews:List<News>){
    LazyRow(modifier=Modifier.fillMaxHeight()) {
        items(topNews){
            news -> NewsCard(
                title = news.title,
                description = news.description,
                imageUrl = news.imageUrl
            )
        }
    }
}
//@Preview
//@Composable
//fun NewsUIPreview(){
//    NewsUI()
//}