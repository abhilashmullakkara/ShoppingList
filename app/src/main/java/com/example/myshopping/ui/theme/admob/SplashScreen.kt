package com.example.myshopping.ui.theme.admob

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myshopping.R
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(navController: NavController) {
    // Define an Animatable for scaling the logo from normal size to beyond the screen size
    val scale = remember { Animatable(1f) }
    val splashDuration = 2500L

    // Launch the scaling animation
    LaunchedEffect(Unit) {
        // Scale up to 3x size (larger than the screen) and then back to normal
        scale.animateTo(
            targetValue = 5f, // Scale up to 3 times the original size
            animationSpec = tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            )
        )
        scale.animateTo(
            targetValue = 0.5f, // Return to original size
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
        // Hold for a moment before navigating
        delay(splashDuration)
        navController.navigate("main_screen") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // UI for splash screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF258171)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.shopping_cart), // Replace with your logo resource
            contentDescription = "App Logo",
            modifier = Modifier
                .scale(scale.value).size(90.dp)
        )
    }
}




