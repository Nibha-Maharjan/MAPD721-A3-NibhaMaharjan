package com.example.mapd721_a3_nibhamaharjan

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScaleAnimationPage() {
    var isScaled by remember { mutableStateOf(false) }

    val scaleFactor by animateFloatAsState(
        targetValue = if (isScaled) 1.5f else 1f
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    isScaled = !isScaled
                },
                modifier = Modifier
                    .size(200.dp * scaleFactor)
            ) {
                Text(text = "Scale Button")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaleAnimationPagePreview() {
    ScaleAnimationPage()
}
