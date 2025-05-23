package com.faiyaz.dummy_news_app

import NewsUIViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.faiyaz.dummy_news_app.ui.Favourites.FavouriteNewsViewModel
import com.faiyaz.dummy_news_app.ui.NewsApp
import com.faiyaz.dummy_news_app.ui.NewsSearch.NewsSearchViewModel
import com.faiyaz.dummy_news_app.ui.Settings.SettingsViewModel

class MainActivity : ComponentActivity() {
    //view models
    private lateinit var newsUiViewModel: NewsUIViewModel
    private lateinit var newsSearchUiViewModel: NewsSearchViewModel
    private lateinit var favUiViewModel: FavouriteNewsViewModel
    private lateinit var settingsViewModel: SettingsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //container initialization
        val appContainer = (application as NewsApplication).container

        //attaching view models with repository dependencies
        newsUiViewModel = NewsUIViewModel(appContainer.newsRepository)
        newsSearchUiViewModel = NewsSearchViewModel(appContainer.newsRepository)
        favUiViewModel = FavouriteNewsViewModel(appContainer.newsRepository)
        settingsViewModel = SettingsViewModel()




        enableEdgeToEdge()
        setContent {
            NewsApp(
                newsUiViewModel=newsUiViewModel,
                newsSearchViewModel=newsSearchUiViewModel,
                newsFavViewModel=favUiViewModel,
                settingsViewModel=settingsViewModel
            )

        }
    }
}

