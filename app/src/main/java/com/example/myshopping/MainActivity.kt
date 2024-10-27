package com.example.myshopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myshopping.ui.theme.MyShoppingTheme
import com.example.myshopping.ui.theme.admob.StringList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyShoppingTheme {
               // HomeScreen()
                //DrawerWithScaffold()
                StringList()
            }
            }
        }
    }

