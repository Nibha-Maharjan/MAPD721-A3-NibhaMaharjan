package com.example.mapd721_a3_nibhamaharjan

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi

@Composable
fun EnterExitAnimationPage() {
    var visible by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image with enter and exit animations
            AnimatedVisibility(
                visible = visible,
                enter = slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(1000)),
                exit = slideOutVertically(targetOffsetY = { -it }, animationSpec = tween(1000))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.orange),
                    contentDescription = "Orange Image",
                    modifier = Modifier.size(100.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button to toggle visibility
            Button(
                onClick = { visible = !visible },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = if (visible) "Hide Image" else "Show Image")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnterExitAnimationPagePreview() {
    EnterExitAnimationPage()
}