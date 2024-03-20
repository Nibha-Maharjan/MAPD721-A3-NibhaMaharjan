package com.example.mapd721_a3_nibhamaharjan

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
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

@Composable
fun TransitionAnimationPage() {
    var rocketPosition by remember { mutableStateOf(0.dp) }

    val rocketAnimationSpec = rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(Unit) {
        rocketPosition = rocketAnimationSpec.value.dp
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedRocket(image = painterResource(id = R.drawable.rocketship), modifier = Modifier.offset(y = rocketPosition))
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Start or restart the animation when the button is clicked
                    rocketPosition = 0.dp
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Animate Rocket")
            }
        }
    }
}


@Composable
fun AnimatedRocket(image: Painter, modifier: Modifier = Modifier) {
    androidx.compose.foundation.Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TransitionAnimationPagePreview() {
    TransitionAnimationPage()
}
