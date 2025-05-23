package com.faiyaz.dummy_news_app.ui.Favourites

import NewsUiState
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.data.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class FavNewsUIState(

    val likedNewsList:List<News>?=null

)

class FavouriteNewsViewModel(
    private val newsRepository: NewsRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(FavNewsUIState())
    val uiState: StateFlow<FavNewsUIState> = _uiState.asStateFlow()
    init{
        updateLikedNews()
    }
    fun updateLikedNews(){
        try {
            viewModelScope.launch {
                val likedNews = newsRepository.getLikedNews()
                _uiState.update {
                    it.copy(
                        likedNewsList = likedNews
                    )
                }
            }
        }catch (e: Exception){

        }
    }
    fun togglelikeNews(news:News){
        try {
            viewModelScope.launch {

                when(news.liked){
                    true ->{
                        println(news.uuid+"-"+news.title.toString()+" IS UNLIKED")
                        newsRepository.unLikeNews(news)
                    }
                    else ->{
                        println(news.uuid+"-"+news.title.toString()+" IS LIKED")
                        newsRepository.likeNews(news)
                    }
                }
                val likedNews = newsRepository.getLikedNews()
                _uiState.update {
                    it.copy(
                        likedNewsList = likedNews
                    )
                }
            }
        }catch(e: Exception){
            Log.d("Error",e.message.toString())
        }
    }
    fun getFavouriteNews():List<News>?{
        return uiState.value.likedNewsList
    }

}