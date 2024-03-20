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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.compose.animation.core.tween

@Composable
fun TransitionAnimationPage() {
    var isRocketAtTop by remember { mutableStateOf(false) }

    val rocketPosition by animateFloatAsState(
        targetValue = if (isRocketAtTop) 0f else 1f,
        animationSpec = tween(durationMillis = 2000)
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
            AnimatedRocket(
                image = painterResource(id = R.drawable.rocketship),
                modifier = Modifier.offset(y = (1 - rocketPosition) * 300.dp)
                    .align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { isRocketAtTop = !isRocketAtTop },
                modifier = Modifier.padding(8.dp)
                    .align(Alignment.Start)
            ) {
                Text(text = if (isRocketAtTop) "Animate Rocket Up" else "Animate Rocket Down")
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
