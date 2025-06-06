package com.faiyaz.dummy_news_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.faiyaz.dummy_news_app.R
import com.faiyaz.dummy_news_app.data.News

@Composable
fun NewsCard(
    title: String ="demo",
    description:String="demo",
    imageUrl:String="demo",
    dateString:String ="23 May 2025",
    onNewsCardTap:()->Unit={},
    onLikeButtonTap:()->Unit={},
    isLiked:Boolean=false
) {

    var isLiked by remember { mutableStateOf(isLiked) }


    val likeColor = when(isLiked){
        false -> Color.Gray
        true -> Color.Red
    }
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onClick = onNewsCardTap
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = imageUrl, // Replace with actual image resource
                contentDescription = description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(350.dp)
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text =title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Clip,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    modifier=Modifier.width(300.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "SCREEN",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "RANT",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFFFC107), // amber
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = dateString.split("T")[0].toString(),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            tint =likeColor,
                            modifier = Modifier
                                .size(32.dp)
                                .clickable(onClick ={
                                    isLiked=!isLiked
                                    onLikeButtonTap()
                                })
                        )
                        Spacer(modifier = Modifier.width(4.dp))
//                        Text("123.1K", style = MaterialTheme.typography.labelSmall)
//
//                        Spacer(modifier = Modifier.width(12.dp))
//
//                        Icon(Icons.Default.Person, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(16.dp))
//                        Spacer(modifier = Modifier.width(4.dp))
//                        Text("567K", style = MaterialTheme.typography.labelSmall)
//
//                        Spacer(modifier = Modifier.width(12.dp))

                        Icon(Icons.Default.Share, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(32.dp))
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
@Preview
@Composable
fun NewsCardPreview(){
    NewsCard()
}