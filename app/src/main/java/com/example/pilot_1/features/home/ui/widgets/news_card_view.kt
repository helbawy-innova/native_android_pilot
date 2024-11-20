package com.example.pilot_1.features.home.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pilot_1.app.widgets.MediaQuery
import com.example.pilot_1.app.widgets.SizedBox
import com.example.pilot_1.features.home.domain.models.NewsModel

@Composable
fun NewsCardView(newsModel: NewsModel) {
    Box(
        modifier = Modifier
            .height(110.dp)
            .width(MediaQuery.getWidth().dp),
    ) {
        Row {
            AsyncImage(
                contentDescription = "",
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop,
                model = newsModel.imageUrl ?: "",
            )
            SizedBox(width = 16.0)
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    newsModel.title ?: "",
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                SizedBox(height = 8.0)
                Text(
                    newsModel.description ?: "", modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f),
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}