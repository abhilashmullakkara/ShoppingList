package com.example.myshopping.ui.theme.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshopping.ui.theme.admob.BannerAdView
import com.google.android.gms.ads.AdSize
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    //HomeScreen()
    DrawerWithScaffold()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerWithScaffold() {

        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val coroutineScope = rememberCoroutineScope()
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier
                        .width(screenWidth * 0.70f)
                        .padding(top = 25.dp, bottom = 25.dp)
                ) {
                    Surface(color = Color(0xFFC2B4E0)) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            item {
                                Text("Drawer Item 1", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }

                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 2", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                            item {
                                Text("Drawer Item 3", modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        ) {
            Surface(color = Color(0xFF977AD6), modifier = Modifier.fillMaxSize()) {
                Scaffold(
                    topBar = {
                        TopAppBar(

                            title = { Text("Shopping List") },
                            navigationIcon = {
                                IconButton(onClick = {
                                    coroutineScope.launch {
                                        if (drawerState.isClosed) {
                                            drawerState.open()
                                        } else {
                                            drawerState.close()
                                        }
                                    }
                                }) {
                                    Icon(Icons.Filled.Menu,
                                        contentDescription = "Menu")
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFF977AD6), // Set your desired background color
                                titleContentColor = Color.White, // Text color
                                navigationIconContentColor = Color.White // Icon color
                            )
                        )
                    },
                    content = {paddingValues ->
                        Surface(
                            color = Color(0xFF977AD6),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)  // Apply paddingValues
                        ) {
                                Column {
                                    BannerAdView(true, AdSize.FULL_BANNER)
                                    AddItemApp()
                                    Text("Main Content")
                                    Text("Main Content")

                                   // MyFloatingActionButton()
                                }

                           // }
                        }
                    }
                )
            }
        }

}







@Composable
fun AddItemApp() {
    // State to hold the list of items
    var itemsList by remember { mutableStateOf(listOf<String>()) }
    // State to keep track of item count
    var itemCount by remember { mutableIntStateOf(1) }
    var itemName by remember { mutableStateOf("") }
    var flagAdd by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = {
                if (itemName.isNotBlank()) {  // Ensure itemName is not empty
                    itemsList = itemsList + itemName // Add item with count
                    itemCount++
                    itemName = "" // Reset itemName after adding
                }
            },
            modifier = Modifier
                .padding(start = 286.dp)
                .fillMaxWidth(0.8f),
            containerColor = Color(0xFF08628A) // Customize FAB color
        ) {
            Icon(
                imageVector = Icons.Default.Add, // Default icon for FAB
                contentDescription = "Add",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        FloatingActionButton(
            onClick = {
                if (itemCount > 1) { // Ensure there's at least one item to remove
                    itemCount--
                    itemsList = itemsList - itemName// Remove item with current count
                }
            },
            modifier = Modifier
                .padding(start = 286.dp)
                .fillMaxWidth(0.8f),
            containerColor = Color(0xFF08628A) // Customize FAB color
        ) {
            Icon(
                imageVector = Icons.Default.Clear, // Default icon for FAB
                contentDescription = "Remove",
                tint = Color.White
            )
        }

        LazyColumn {
            items(itemsList) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }

        // Show TextField only when flagAdd is true
        if (flagAdd) {
            OutlinedTextField(
                value = itemName,
                onValueChange = { itemName = it },
                label = { Text("Add Item") }
            )
        }

//        // Button to toggle flagAdd
//        Button(
//            onClick = { flagAdd = !flagAdd }, // Toggle flag to show/hide TextField
//            modifier = Modifier.padding(top = 16.dp)
//        ) {
//            Text(if (flagAdd) "Hide Input" else "Add Item")
//        }
    }
}


