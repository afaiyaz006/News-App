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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.faiyaz.dummy_news_app.R
import com.faiyaz.dummy_news_app.data.utils.NewsCategory
import com.faiyaz.dummy_news_app.ui.NewsApp
import com.faiyaz.dummy_news_app.ui.NewsDetails.NewsDetailUI
import com.faiyaz.dummy_news_app.ui.components.CategoryButton
import com.faiyaz.dummy_news_app.ui.components.CircularLoading
import com.faiyaz.dummy_news_app.ui.components.NewsTopicSelector
import com.faiyaz.dummy_news_app.ui.navigation.NewsAppRoute

@Composable
fun NewsUI(
    newsUiViewModel: NewsUIViewModel,
    onNewsCardTap: ()->Unit={},
    onViewAllClick: ()->Unit={},
    onFeaturedNewsClick:()->Unit={},
    onLikeButtonClicked:(News)->Unit={},
) {
    val newsViewState by newsUiViewModel.uiState.collectAsStateWithLifecycle()
    val topNews = newsViewState.topNews
    val categoryNews = newsViewState.categoryNews

    Log.d("Data", topNews.toString())

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        NewsHeader(onViewAllClick=onViewAllClick)

        var categories = NewsCategory.getAllValues()
        var categoriesLocal: @Composable (String)->String ={ category ->
           when (category) {
                "business" -> stringResource(R.string.business)
                "entertainment" -> stringResource(R.string.entertainment)
                "general" -> stringResource(R.string.general)
                "health" -> stringResource(R.string.health)
                "science" -> stringResource(R.string.science)
                "sports" -> stringResource(R.string.sports)
                "technology" -> stringResource(R.string.technology)
                else -> category
            }.toString()
        }
        LazyRow(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                CategoryButton(
                    text = categoriesLocal(category),
                    selected = newsViewState.selectedCategory == category.toString(),
                    onClick = {
                        newsUiViewModel.updateCategory(category.toString())
                    }
                )
            }
        }

        NewsGallery(
            categoryNews = categoryNews,
            onNewsCardTap = { news ->
                newsUiViewModel.selectNews(news)
                onNewsCardTap()
            },
            onLikeButtonClicked=onLikeButtonClicked,
            isLoading=newsViewState.isLoading
        )

        NewsHeader(headerName = stringResource(R.string.featured),onViewAllClick=onFeaturedNewsClick)
        NewsGalleryFeatured(
            topNews,
            onNewsCardTap={ news ->
                newsUiViewModel.selectNews(news)
                onNewsCardTap()
            },
            onLikeButtonClicked=onLikeButtonClicked,
            isLoading = newsViewState.isLoading
        )
    }
}

@Composable
fun NewsGallery(categoryNews: List<News>, 
                onNewsCardTap: (News) -> Unit,
                onLikeButtonClicked: (News) -> Unit,
                isLoading: Boolean=false) {
    if(isLoading){
        CircularLoading()
    }else {
        LazyRow {
            items(categoryNews) { news ->
                NewsCard(
                    title = news.title,
                    description = news.description,
                    imageUrl = news.imageUrl,
                    dateString = news.publishedAt,
                    isLiked = news.liked,
                    onNewsCardTap = { onNewsCardTap(news) },
                    onLikeButtonTap = { onLikeButtonClicked(news) }
                )
            }
        }
    }
}
@Composable
fun NewsGalleryFeatured(topNews:List<News>,
                        onNewsCardTap: (News) -> Unit,
                        onLikeButtonClicked:(News)->Unit,
                        isLoading: Boolean=false){
    if(isLoading){
        CircularLoading()
    }else {
        LazyRow(modifier = Modifier.fillMaxHeight()) {
            items(topNews) { news ->
                NewsCard(
                    title = news.title,
                    description = news.description,
                    imageUrl = news.imageUrl,
                    dateString = news.publishedAt,
                    isLiked = news.liked,
                    onNewsCardTap = { onNewsCardTap(news) },
                    onLikeButtonTap = { onLikeButtonClicked(news) }
                )
            }
        }
    }
}
//@Preview
//@Composable
//fun NewsUIPreview(){
//    NewsUI()
//}