package com.example.myshopping.ui.theme.admob

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("main_screen") { MainScreen() }
    }
}

@Composable
fun MainScreen() {
    ShoppingListScreen()
    // Your main screen content here
    //Text(text = "Welcome to the Shopping App!", fontSize = 24.sp)
}
