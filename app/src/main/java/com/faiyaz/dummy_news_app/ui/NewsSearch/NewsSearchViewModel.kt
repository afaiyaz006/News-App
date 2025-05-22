package com.faiyaz.dummy_news_app.ui.NewsSearch

import NewsUiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.data.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class NewsSearchUIState(

    val newsList:List<News>?=null

)

class NewsSearchViewModel(
    private val newsRepository: NewsRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(NewsSearchUIState())
    val uiState: StateFlow<NewsSearchUIState> = _uiState.asStateFlow()

    fun searchNews(query:String){
        try {
            viewModelScope.launch {
                val news = newsRepository.searchNews(query)
                _uiState.update {
                    it.copy(
                        newsList = news
                    )
                }
            }
        }catch(e: Exception){
            _uiState.update {
                it.copy(
                    newsList = emptyList()
                )
            }
        }
    }
}