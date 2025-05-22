package com.faiyaz.dummy_news_app

import NewsUIViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.faiyaz.dummy_news_app.di.AppContainer
import com.faiyaz.dummy_news_app.ui.NewsApp
import com.faiyaz.dummy_news_app.ui.NewsSearch.NewsSearchViewModel

import com.faiyaz.dummy_news_app.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var newsUiViewModel: NewsUIViewModel
    private lateinit var newsSearchUiViewModel: NewsSearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = (application as NewsApplication).container
        newsUiViewModel = NewsUIViewModel(appContainer.newsRepository)
        newsSearchUiViewModel = NewsSearchViewModel(appContainer.newsRepository)
        enableEdgeToEdge()
        setContent {
            NewsApp(
                newsUiViewModel=newsUiViewModel,
                newsSearchViewModel=newsSearchUiViewModel
            )

        }
    }
}

