package com.example.myshopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myshopping.ui.theme.MyShoppingTheme
import com.example.myshopping.ui.theme.admob.AppNavigation
import com.example.myshopping.ui.theme.admob.ShoppingListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyShoppingTheme {
               // HomeScreen()
                //DrawerWithScaffold()
                //StringList()
               // ShoppingListScreen()
                AppNavigation()
            }
            }
        }
    }







