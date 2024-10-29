package com.example.myshopping.ui.theme.admob


import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myshopping.R
import com.example.myshopping.ui.theme.item.Item
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlin.random.Random

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import kotlinx.coroutines.launch

//
//@SuppressLint("VisibleForTests")
//@Composable
//fun BannerAdView(isTest: Boolean = true ,banner: AdSize = AdSize.BANNER) {
//    val unitId = if (isTest) stringResource(id = R.string.ad_mob_test_banner_id) else stringResource(
//        id =R.string.ad_mob_banner_id  //ca-app-pub-9950046999139130/7284135590
//    )
//    Box(modifier = Modifier.fillMaxSize()) {
//        AndroidView(
//            factory = { context ->
//                AdView(context).apply {
//                    setAdSize(banner)
//                    adUnitId = unitId
//                    loadAd(com.google.android.gms.ads.AdRequest.Builder().build())
//                }
//            },
//            modifier = Modifier
//                .align(Alignment.BottomCenter) // Align banner ad at the bottom center
//                .fillMaxWidth()
//        )
//    }
//}
//@Composable
//fun ReadAString(onAddItem: (Item) -> Unit) {
//    var itemName by remember { mutableStateOf("") }
//    var unit by remember { mutableStateOf("") }
//    val newItemList = remember { mutableStateListOf<Item>() }
//
//    Surface(color = Color(0xFFB9F6CA)) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, top = 15.dp, bottom = 10.dp),
//            horizontalArrangement = Arrangement.SpaceBetween, // Ensures proper spacing
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = itemName,
//                onValueChange = { itemName = it },
//                modifier = Modifier
//                    .weight(0.35f)
//                    .padding(end = 12.dp),
//                label = { Text("Item") }
//            )
//            TextField(
//                value = unit,
//                onValueChange = { unit = it },
//                modifier = Modifier
//                    .weight(0.25f)
//                    .padding(end = 12.dp),
//                label = { Text("Qty") }
//            )
//
//            TextButton(
//                onClick = {
//                    if (itemName.isNotBlank() ) {
//                        val itemId = (newItemList.size + 1)
//                        val newItem = Item(name = itemName, quantity = unit,id=itemId)
//                        // Create a new instance for each item
//                        onAddItem(newItem)
//                        newItemList.add(newItem) // Add new unique item to the list
//                        itemName = "" // Reset input field
//                        unit = ""
//                    }
//                },
//                colors = ButtonDefaults.textButtonColors(
//                    containerColor = Color(0xFF08628A),
//                    contentColor = Color.White
//                ),
//                modifier = Modifier.weight(0.25f)
//            ) {
//                Text("Add Item")
//            }
//        }
//    }
//}
//
//@Composable
//fun StringList() {
//    // Define the Surface with a background color
//    Surface(
//        color = Color(0xFF258171),
//        modifier = Modifier.fillMaxSize()
//    ) {
//        // Use remember to keep the mutable state
//        val newItemList = remember { mutableStateListOf<Item>() }
//        var flag by remember { mutableStateOf(true) }
//        var viewFlag by remember { mutableStateOf(false) }
//
//        // Get context and initialize the database and ViewModel
//        val context = LocalContext.current
//        val database = DatabaseInstance.getDatabase(context)
//        val repository = ItemRepository(database.itemDao())
//        val itemViewModel = ItemViewModel(repository)
//
//        // Main column layout
//        Column {
//            // Input area for adding items
//            ReadAString(onAddItem = { newItem ->
//                newItemList.add(newItem)
//            })
//
//            // Displaying items in a list
//            ItemListDisplay(newItemList, itemViewModel)
//            // Save or view buttons based on flag state
//            if (flag) {
//                SaveButton(newItemList, itemViewModel) { flag = false }
//            } else {
//                SavedViewButtons { flag = true; viewFlag = true }
//            }
//
//            // Show com.example.myshopping.ui.theme.admob.ItemListScreen when viewFlag is true
//            if (viewFlag) {
//                ItemListScreen(itemViewModel = itemViewModel)
//            }
//       }
//    }
//}
//
//// Composable function to display the items
//@Composable
//fun ItemListDisplay(newItemList: MutableList<Item>, itemViewModel: ItemViewModel) {
//    // Iterate over the item list and display each item
//    newItemList.forEachIndexed { index, item ->
//        itemViewModel.updateItem(item)
//        Row(modifier = Modifier.padding(start=8.dp)) {
//            // Set item ID
//            item.id = (index + 1)
//
//            // Display the item's index and name
//            Text(
//                text = "${item.id}. ${item.name}",
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 16.sp,
//                modifier = Modifier.weight(0.5f).padding(start = 10.dp)
//            )
//
//            // Display the quantity
//            Text(
//                text = item.quantity,
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold,
//                modifier = Modifier.padding(start = 10.dp,end=90.dp)
//            )
//
//            // Button to remove the item
//            FloatingActionButton(
//                onClick = {
//                    newItemList.remove(item)
//                },
//                modifier = Modifier.size(30.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Delete,
//                    contentDescription = "Remove",
//                    tint = Color.Red
//                )
//            }
//        }
//    }
//}
//
//// Composable function for the save button
@Composable
fun SaveButton(newItemList: List<Item>, itemViewModel: ItemViewModel, onSave: () -> Unit) {
    if (newItemList.isNotEmpty()) {
        TextButton(
            onClick = {
                newItemList.forEach { item ->
                    //Log.d("SaveButton", "Inserting item: ${item.name}, Quantity: ${item.quantity}")
                    Log.d("PrimaryKey", "Inserting item: ${item.id}, Name: ${item.name} Quantity: ${item.quantity}")

                    itemViewModel.insertItem(item)
                }
                onSave() // Call onSave to update the flag
            },
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFFAF0F0C),
                contentColor = Color.White
            ),
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Text("SAVE")
        }
    }
}
//
//// Composable function for saved and view buttons
//@Composable
//fun SavedViewButtons(onViewClick: () -> Unit) {
//    Column {
//        TextButton(
//            onClick = { /* You may implement any action needed */ },
//            colors = ButtonDefaults.textButtonColors(
//                containerColor = Color(0xFF08628A),
//                contentColor = Color.White
//            ),
//            modifier = Modifier.padding(8.dp)
//        ) {
//            Text("SAVED")
//        }
//
//        TextButton(
//            onClick = onViewClick,
//            colors = ButtonDefaults.textButtonColors(
//                containerColor = Color(0xFF08628A),
//                contentColor = Color.White
//            )
//        ) {
//            Text("View")
//        }
//
//        BannerAdView(true, AdSize.FULL_BANNER)
//    }
//}


@SuppressLint("VisibleForTests")
@Composable
fun BannerAdView(
    isTest: Boolean = true,
    banner: AdSize = AdSize.BANNER
) {
    val unitId = if (isTest) stringResource(R.string.ad_mob_test_banner_id)
    else stringResource(R.string.ad_mob_banner_id)
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                AdView(context).apply {
                    setAdSize(banner)
                    adUnitId = unitId
                    loadAd(AdRequest.Builder().build())
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun AddItemInput(
    onAddItem: (Item) -> Unit
) {
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val coroutineScope = rememberCoroutineScope()

    Row(modifier = Modifier.padding(8.dp)){
        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item") },
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .focusRequester(focusRequester),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (itemName.isNotEmpty() && itemQuantity.isNotEmpty()) {
                        onAddItem(Item(name = itemName, quantity = itemQuantity))
                        itemName = ""
                        itemQuantity = ""

                        // Request focus back to the first input field
                        coroutineScope.launch {
                            focusRequester.requestFocus()
                        }
                    }
                }
            )
        )

        Spacer(modifier = Modifier.width(12.dp))

        TextField(
            value = itemQuantity,
            onValueChange = { itemQuantity = it },
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth(0.5f),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (itemName.isNotEmpty() && itemQuantity.isNotEmpty()) {
                        onAddItem(Item(name = itemName, quantity = itemQuantity))
                        itemName = ""
                        itemQuantity = ""

                        // Request focus back to the first input field
                        coroutineScope.launch {
                            focusRequester.requestFocus()
                        }
                    }
                }
            )
        )

        Spacer(modifier = Modifier.width(10.dp))

        Button(onClick = {
            if (itemName.isNotEmpty() && itemQuantity.isNotEmpty()) {
                onAddItem(Item(name = itemName, quantity = itemQuantity))
                itemName = ""
                itemQuantity = ""

                // Request focus back to the first input field
                coroutineScope.launch {
                    focusRequester.requestFocus()
                }
            }
        }, colors= ButtonDefaults.buttonColors(
            containerColor = Color(0xFF08628A),
            contentColor = Color.White
        )) {
            Text("Add", fontSize = 14.sp,color=Color.White)
        }
    }
}

@Composable
fun ShoppingListScreen() {
    Surface(color = Color(0xffb3acaa)) {

        val newItemList = remember { mutableStateListOf<Item>() }
        val context = LocalContext.current
        val itemViewModel = viewModel<ItemViewModel> {
            val database = DatabaseInstance.getDatabase(context)
            val repository = ItemRepository(database.itemDao())
            ItemViewModel(repository)
        }

        var showSavedItems by remember { mutableStateOf(false) }

        Column(modifier = Modifier.fillMaxSize()) {
            SimpleTopAppBar()
            AddItemInput(onAddItem = { newItem ->
                newItemList.add(newItem)
            })

            // Ensure NewItemListDisplay recomposes when newItemList changes
            NewItemListDisplay(newItemList, itemViewModel)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(
                    onClick = { newItemList.forEach { itemViewModel.insertItem(it)
                    Toast.makeText(context, "Items Saved...", Toast.LENGTH_SHORT).show()
                    } },
                    colors = ButtonDefaults.textButtonColors(containerColor = Color(0xFFAF0F0C))
                ) { Text("Save Items", color = Color.White) }

                TextButton(
                    onClick = { showSavedItems = true },
                    colors = ButtonDefaults.textButtonColors(containerColor = Color(0xFF08628A))
                ) { Text("View Saved", color = Color.White) }

                TextButton(
                    onClick = {
                        newItemList.clear()  // Trigger recomposition
                        showSavedItems = false // Hide saved items view after clearing
                    },
                    colors = ButtonDefaults.textButtonColors(containerColor = Color(0xFF08628A))
                ) { Text("CLEAR", color = Color.White) }
            }

            if (showSavedItems) {
                ItemListScreen(itemViewModel)
            }

            BannerAdView(isTest = true, banner = AdSize.FULL_BANNER)
        }
    }
}


@Composable
fun ItemListDisplay(newItemList: MutableList<Item>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        itemsIndexed(newItemList) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .background(Color(0xFF258171), RoundedCornerShape(8.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${index + 1}. ${item.name}",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 8.dp)
                )
                Text(
                    text = item.quantity,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .weight(0.2f)
                        .padding(end = 8.dp)
                )
                IconButton(onClick = {
                    newItemList.remove(item)
                })
                {
                    Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color.Red)
                }
            }
        }
    }
}

@Composable
fun NewItemListDisplay(newItemList: MutableList<Item>, itemViewModel: ItemViewModel) {
    // Iterate over the item list and display each item
    newItemList.forEachIndexed { index, item ->
        itemViewModel.updateItem(item)
        Row(modifier = Modifier.padding(start=8.dp)) {
            // Set item ID
           // item.id = ((index + 1).toString())

            // Display the item's index and name
            Text(
                text = "${index+1}. ${item.name}",
                color = Color.Blue,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 10.dp)
            )

            // Display the quantity
            Text(
                text = item.quantity,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp,end=90.dp)
            )

            // Button to remove the item
            FloatingActionButton(
                onClick = {
                    newItemList.remove(item)
                },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Remove",
                    tint = Color.Red
                )
            }
        }
    }
}


@Composable
fun SimpleTopAppBar() {
    TopAppBar(
        title = { Text("My Shopping List") },
        backgroundColor = Color(0xFF08628A),
        contentColor = Color.White,
        actions = {
            IconButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        }
    )
}

fun generateRandomKey(): Int {
    return Random.nextInt(1000, 10000) // Generates a random number from 1000 to 9999
}




