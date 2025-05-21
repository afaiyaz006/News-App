package com.faiyaz.dummy_news_app.ui.NewsUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faiyaz.dummy_news_app.ui.components.NewsCard
import com.faiyaz.dummy_news_app.ui.components.NewsHeader

import com.faiyaz.dummy_news_app.ui.components.NewsTopicSelector
import io.ktor.http.headers

@Composable
fun NewsUI(){
    Column(modifier = Modifier.fillMaxHeight()){
        NewsHeader()
        NewsTopicSelector()
        NewsGallery()
        NewsHeader(headerName = "Featured")
        NewsGalleryFeatured()
    }
}
@Composable
fun NewsGallery(){
    LazyRow {
        items(10){
            NewsCard()
        }
    }
}
@Composable
fun NewsGalleryFeatured(){
    LazyColumn {
        items(10){
            NewsCard()
        }
    }
}
@Preview
@Composable
fun NewsUIPreview(){
    NewsUI()
}