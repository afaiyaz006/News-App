package com.faiyaz.dummy_news_app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFFD32F2F) else Color.White
    val contentColor = if (selected) Color(0xFFF1EDE4) else Color.Gray
    val borderStroke = if (selected) null else BorderStroke(2.dp, Color(0xFFD32F2F))

    Surface(
        shape = RoundedCornerShape(50), // pill shape
        color = backgroundColor,
        border = borderStroke,
        modifier = Modifier
            .padding(4.dp)
            .height(48.dp)
            .wrapContentWidth()
            .clickable(onClick = onClick),
        tonalElevation = if (selected) 4.dp else 0.dp,
        shadowElevation = if (selected) 4.dp else 0.dp
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                text = text,
                color = contentColor,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
@Preview
@Composable
fun CategoryButtonEmptyPreview(){
    CategoryButton(text="Red", selected = false) { }
}

@Preview
@Composable
fun CategoryButtonSelectedPreview(){
    CategoryButton(text="Red", selected = true) { }
}
