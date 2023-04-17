package com.pragma.breeds.ui.presentation.feature.cat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.pragma.breeds.data.model.Cat
import com.pragma.breeds.network.Constants
import com.pragma.breeds.ui.presentation.utilsviews.LoadingView
import com.pragma.breeds.ui.presentation.utilsviews.RatingView

@Composable
fun CatScreen(navController: NavController, catViewModel: CatViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (catViewModel.state.isLoading) {
            LoadingView()
        } else {
            LazyColumn {
                catViewModel.state.response?.let {
                    items(it){ cat ->
                        CatItem(cat)
                    }
                }
            }
        }
    }
}

@Composable
fun CatItem(cat: Cat) {
    Card {
        Column {
            Row {
               Text("Nombre ${cat.breedName}")
            }

            Row {
                Text("Raza ${cat.breedName}")
            }

            AsyncImage(
                model = "${Constants.IMAGE_BASE_URL}${cat.imageUrl}.jpg",
                contentDescription = "Imagén para gatos"
            )

            Row {
                Row {
                    Text("Pais de origen ${cat.origin}")
                }
                cat.intelligence?.toFloat()?.let {
                    RatingView(rating = it, spaceBetween = 3.dp)
                }
            }

        }
    }
}