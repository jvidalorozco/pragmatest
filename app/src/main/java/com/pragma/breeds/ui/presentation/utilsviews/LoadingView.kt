package com.pragma.breeds.ui.presentation.utilsviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingView() = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color.White)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(400.dp)
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.size(40.dp))

        CircularProgressIndicator(
            modifier = Modifier.size(size = 100.dp),
            color = Color.Blue,
            strokeWidth = 6.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingView()
}