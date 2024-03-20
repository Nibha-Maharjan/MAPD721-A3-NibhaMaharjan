package com.example.mapd721_a3_nibhamaharjan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mapd721_a3_nibhamaharjan.ui.theme.MAPD721A3NibhaMaharjanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A3NibhaMaharjanTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomePage(navController) }
        composable("transitionAnimation") { TransitionAnimationPage() }
        composable("scaleAnimation") { ScaleAnimationPage() }
        composable("infiniteAnimation") { InfiniteAnimationPage() }
        composable("enterExitAnimationPage") { EnterExitAnimationPage() }
    }
}

@Composable
fun HomePage(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeButton(text = "Transition Animation") {
                    navController.navigate("transitionAnimation")
                }
                HomeButton(text = "Scale Animation", onClick = {
                    navController.navigate("scaleAnimation")
                })
                HomeButton(text = "Infinite Animation", onClick = {
                    navController.navigate("infiniteAnimation")
                })
                HomeButton(text = "Enter Exit Animation", onClick = {
                    navController.navigate("enterExitAnimationPage")
                })
            }
        }
    }
}


@Composable
fun HomeButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    MAPD721A3NibhaMaharjanTheme {
        HomePage(navController = rememberNavController())
    }
}
