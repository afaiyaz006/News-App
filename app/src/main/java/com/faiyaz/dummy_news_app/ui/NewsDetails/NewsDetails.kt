package com.faiyaz.dummy_news_app.ui.NewsDetails

import NewsUIViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.faiyaz.dummy_news_app.R
@Composable
fun NewsDetailUI(
    newsUIViewModel: NewsUIViewModel
) {
        val newsViewState by newsUIViewModel.uiState.collectAsStateWithLifecycle()
        val selectedNews = newsViewState.selectedNews
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            // News Image
            AsyncImage(
                model = selectedNews?.imageUrl,
                contentDescription = selectedNews?.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Headline
            Text(
                text = selectedNews?.title.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Category and Stats Row
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SCREEN",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "RANT",
                    color = Color.Red,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = selectedNews?.publishedAt.toString().split("T")[0],
                    color = Color.Black,
                    fontSize = 12.sp
                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_launcher_background),
//                        contentDescription = "Views",
//                        modifier = Modifier.size(16.dp),
//                        tint = Color.Gray
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text(
//                        text = "123.1K",
//                        color = Color.Gray,
//                        fontSize = 12.sp
//                    )
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_launcher_background),
//                        contentDescription = "Comments",
//                        modifier = Modifier.size(16.dp),
//                        tint = Color.Gray
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text(
//                        text = "567K",
//                        color = Color.Gray,
//                        fontSize = 12.sp
//                    )
//                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Description
            Text(
                text= selectedNews?.description?: "",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

}
//@Preview
//@Composable
//fun NewsDetailPreview(){
//    NewsDetailUI()
//}