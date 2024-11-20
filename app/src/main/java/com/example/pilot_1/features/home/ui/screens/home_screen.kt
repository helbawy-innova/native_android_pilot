package com.example.pilot_1.features.home.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pilot_1.app.widgets.ListView
import com.example.pilot_1.app.widgets.SizedBox
import com.example.pilot_1.configurations.ErrorState
import com.example.pilot_1.configurations.LoadingState
import com.example.pilot_1.configurations.SuccessState
import com.example.pilot_1.features.home.ui.viewmodels.HomeViewModel
import com.example.pilot_1.features.home.ui.widgets.NewsCardView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.observeStates()
    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(text = "Top News", fontWeight = FontWeight.Bold)
                    },
                )
                Divider(
                    thickness = .5.dp
                )
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
        {
            when (state) {
                is LoadingState -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is SuccessState -> {
                    ListView.Separated(

                        itemCount = viewModel.newsList.size,
                        itemBuilder = { index ->
                            {
                                NewsCardView(viewModel.newsList[index])
                            }
                        },
                        separator = {
                            SizedBox(height = 24.0)
                        },
                        contentPadding = PaddingValues(16.dp)

                    )
                }

                is ErrorState -> {
                    Text(text = "Error", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

