package com.faiyaz.dummy_news_app.ui.components

import NewsUiState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faiyaz.dummy_news_app.data.utils.NewsCategory

@Composable
fun NewsTopicSelector(){
    val categories = NewsCategory.getAllValues()
    var selectedNews by remember{ mutableStateOf(NewsCategory.BUSINESS) }
    LazyRow(
        modifier= Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories){
            category -> CategoryButton(
                text = category.toString(),
                selected =selectedNews.value==category,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun NewsTopicSelectorPreview(){
    NewsTopicSelector()
}