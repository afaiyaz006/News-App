
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.data.NewsRepository
import com.faiyaz.dummy_news_app.data.utils.NewsCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class NewsUiState(
    val topNews: List<News> = emptyList(),
    val categoryNews: List<News> = emptyList(),
    val selectedCategory: String = NewsCategory.BUSINESS.value,
    val selectedNews: News? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class NewsUIViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    init {
        fetchTopNews()
        fetchNewsByCategory("Business")
    }

    fun fetchTopNews() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val news = newsRepository.getTopNews()
                Log.d("FROM VIEWMODEL", news.toString())
                _uiState.update {
                    it.copy(
                        topNews = news ?: emptyList(),
                        errorMessage = null,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        errorMessage = "Failed to load top news: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }

    fun fetchNewsByCategory(category: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val news = newsRepository.getFeatureWiseNews(category)
                println(news)
                _uiState.update {
                    it.copy(
                        categoryNews = news ?: emptyList(),
                        errorMessage = null,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        errorMessage = "Failed to load category news: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }
    fun updateCategory(category: String){

        viewModelScope.launch {
            try {
                _uiState.update {
                    it.copy(
                        selectedCategory = category
                    )
                }
                val news = newsRepository.getFeatureWiseNews(category)

                _uiState.update {
                    it.copy(
                        categoryNews = news ?: emptyList(),
                        errorMessage = null,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        errorMessage = "Failed to load category news: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }
    fun getCategory():String{
        return uiState.value.selectedCategory
    }
    fun getCurrentCategoryNews():List<News>?{
        return uiState.value.categoryNews
    }
    fun getCurrentTopNews():List<News>?{
        return uiState.value.topNews
    }
    fun selectNews(news:News){
        _uiState.update {
            it.copy(
                selectedNews = news
            )
        }
    }
}