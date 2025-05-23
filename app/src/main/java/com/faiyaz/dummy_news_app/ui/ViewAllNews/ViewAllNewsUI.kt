import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faiyaz.dummy_news_app.data.News
import com.faiyaz.dummy_news_app.ui.components.NewsCard

@Composable
fun ViewAllNewsUI(
    newsList:List<News>?,
    selectedTopic:String,
    onNewsCardTap: (news:News)->Unit={},
    onLikeButtonClicked: (News)->Unit={}

){
    Column(modifier = Modifier.padding(16.dp)){
        Text(
            text=selectedTopic,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(){
            items(newsList?:emptyList()){
                news -> NewsCard(
                    title = news.title,
                    description = news.description,
                    imageUrl = news.imageUrl,
                    onNewsCardTap={onNewsCardTap(news)},
                    onLikeButtonTap = {onLikeButtonClicked(news)}
                )
            }
        }
    }
}
//@Preview
//@Composable
//fun PreviewViewAllNewsUI(){
//    ViewAllNewsUI()
//}