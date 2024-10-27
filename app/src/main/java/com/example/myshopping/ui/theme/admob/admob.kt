package com.example.myshopping.ui.theme.admob


import ItemListScreen
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import com.example.myshopping.R
import com.example.myshopping.ui.theme.item.Item
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@SuppressLint("VisibleForTests")
@Composable
fun BannerAdView(isTest: Boolean = true ,banner: AdSize = AdSize.BANNER) {
    val unitId = if (isTest) stringResource(id = R.string.ad_mob_test_banner_id) else stringResource(
        id =R.string.ad_mob_banner_id  //ca-app-pub-9950046999139130/7284135590
    )
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                AdView(context).apply {
                    setAdSize(banner)
                    adUnitId = unitId
                    loadAd(com.google.android.gms.ads.AdRequest.Builder().build())
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align banner ad at the bottom center
                .fillMaxWidth()
        )
    }
}
@Composable
fun ReadAString(onAddItem: (Item) -> Unit) {
    var itemName by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("") }
    val newItemList = remember { mutableStateListOf<Item>() }

    Surface(color = Color(0xFFB9F6CA)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 15.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Ensures proper spacing
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = itemName,
                onValueChange = { itemName = it },
                modifier = Modifier
                    .weight(0.35f)
                    .padding(end = 12.dp),
                label = { Text("Item") }
            )
            TextField(
                value = unit,
                onValueChange = { unit = it },
                modifier = Modifier
                    .weight(0.25f)
                    .padding(end = 12.dp),
                label = { Text("Qty") }
            )

            TextButton(
                onClick = {
                    if (itemName.isNotBlank() ) {
                        val itemId = (newItemList.size + 1)
                        val newItem = Item(name = itemName, quantity = unit,id=itemId)
                        // Create a new instance for each item
                        onAddItem(newItem)
                        newItemList.add(newItem) // Add new unique item to the list
                        itemName = "" // Reset input field
                        unit = ""
                    }
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color(0xFF08628A),
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(0.25f)
            ) {
                Text("Add Item")
            }
        }
    }
}
//
//@Composable
//fun StringList() {
//    Surface(
//        color = Color(0xFF258171),
//        modifier = Modifier.fillMaxSize()
//    ) {
//        val newItemList = remember { mutableStateListOf<Item>() }
//        var flag by remember { mutableStateOf(true) }
//        var viewFlag by remember { mutableStateOf(false) }
//        val context= LocalContext.current
//        val database = DatabaseInstance.getDatabase(context)
//        val repository = ItemRepository(database.itemDao())
//        val itemViewModel = ItemViewModel(repository)
//        Column {
//            ReadAString(onAddItem = { newItem ->
//                newItemList.add(newItem)
//            })
//           // ItemListScreen(itemViewModel = itemViewModel)
//            newItemList.forEachIndexed  { _, item ->
//                Row {
//                    Spacer(modifier = Modifier.width(8.dp))
//                    item.id=(newItemList.indexOf(item) + 1)
//                  //  Text(item.id, color = Color.White,fontWeight = FontWeight.SemiBold,fontSize = 16.0.sp)
//                    Text("${newItemList.indexOf(item) + 1}.", color = Color.White,fontWeight = FontWeight.SemiBold,fontSize = 16.0.sp)
//                    Text(
//                        text = item.name,
//                        color = Color.White,
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 16.0.sp,
//                        modifier = Modifier.padding(start = 10.dp)
//                    )
//                    Spacer(modifier = Modifier
//                        .width(8.dp)
//                        .weight(0.5f)
//                        .padding(end = 20.dp))
//                    Text(
//                        text = item.quantity,
//                        color = Color.White,
//                        fontWeight = FontWeight.SemiBold,
//                        modifier = Modifier.padding(start = 10.dp,end=150.dp)
//                    )
//
//                    Spacer(modifier = Modifier.width(8.dp))
//                    FloatingActionButton(onClick = {
//                        newItemList.remove(item)
//                    },modifier = Modifier.size(30.dp),) {
//                        Icon(
//                            imageVector = Icons.Default.Delete, // Default icon for FAB
//                            contentDescription = "Remove",
//                            tint = Color.Red
//                        )
//                    }
//                }
//            }
//            if (flag) {
//                Column(modifier = Modifier.weight(0.5f)) {
//                    if(newItemList.isNotEmpty())
//                TextButton(
//                    onClick = {
//                        flag = false
//                        newItemList.forEach { item ->
//                            itemViewModel.insertItem(item)
//                        }
//
//                        // Hide the input when NO is clicked
//                    },
//                    colors = ButtonDefaults.textButtonColors(
//                        containerColor = Color(0xFFAF0F0C),
//                        contentColor = Color.White
//                    ),
//                    modifier = Modifier.padding(start = 15.dp)
//                ) {
//                    Text("SAVE")
//
//                }
//                    BannerAdView(true, AdSize.FULL_BANNER)
//
//            }
//            }
//
//            else {
//                Column {
//                TextButton(
//                    onClick = {
//
//                        flag = true // Show the input again when YES is clicked
//                    },
//                    colors = ButtonDefaults.textButtonColors(
//                        containerColor = Color(0xFF08628A),
//                        contentColor = Color.White
//                    ),
//                ) {
//                    Text("SAVED")
//                }
//                    //
//
//                    TextButton(
//                        onClick = {
//                            viewFlag=true
//
//                            //flag = true // Show the input again when YES is clicked
//                        },
//                        colors = ButtonDefaults.textButtonColors(
//                            containerColor = Color(0xFF08628A),
//                            contentColor = Color.White
//                        ),
//                    ) {
//                        Text("View")
//                    }
//
//
//                BannerAdView(true, AdSize.FULL_BANNER)
//                }
//            }
//            if(viewFlag)
//                ItemListScreen(itemViewModel = itemViewModel)
//
//        }
//    }
//}




@Composable
fun StringList() {
    // Define the Surface with a background color
    Surface(
        color = Color(0xFF258171),
        modifier = Modifier.fillMaxSize()
    ) {
        // Use remember to keep the mutable state
        val newItemList = remember { mutableStateListOf<Item>() }
        var flag by remember { mutableStateOf(true) }
        var viewFlag by remember { mutableStateOf(false) }

        // Get context and initialize the database and ViewModel
        val context = LocalContext.current
        val database = DatabaseInstance.getDatabase(context)
        val repository = ItemRepository(database.itemDao())
        val itemViewModel = ItemViewModel(repository)

        // Main column layout
        Column {
            //ItemListScreen(itemViewModel = itemViewModel)
            // Input area for adding items
            ReadAString(onAddItem = { newItem ->
                newItemList.add(newItem)
            })

            // Displaying items in a list
            ItemListDisplay(newItemList, itemViewModel)

            // Save or view buttons based on flag state
            if (flag) {
                SaveButton(newItemList, itemViewModel) { flag = false }
            } else {
                SavedViewButtons { flag = true; viewFlag = true }
            }

            // Show ItemListScreen when viewFlag is true
            if (viewFlag) {
                ItemListScreen(itemViewModel = itemViewModel)
            }
       }
    }
}

// Composable function to display the items
@Composable
fun ItemListDisplay(newItemList: MutableList<Item>, itemViewModel: ItemViewModel) {
    // Iterate over the item list and display each item
    newItemList.forEachIndexed { index, item ->
        itemViewModel.updateItem(item)
        Row(modifier = Modifier.padding(start=8.dp)) {
            // Set item ID
            item.id = (index + 1)

            // Display the item's index and name
            Text(
                text = "${item.id}. ${item.name}",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.weight(0.5f).padding(start = 10.dp)
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

// Composable function for the save button
@Composable
fun SaveButton(newItemList: List<Item>, itemViewModel: ItemViewModel, onSave: () -> Unit) {
    if (newItemList.isNotEmpty()) {
        TextButton(
            onClick = {
                newItemList.forEach { item ->
                    Log.d("SaveButton", "Inserting item: ${item.name}, Quantity: ${item.quantity}")
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

// Composable function for saved and view buttons
@Composable
fun SavedViewButtons(onViewClick: () -> Unit) {
    Column {
        TextButton(
            onClick = { /* You may implement any action needed */ },
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFF08628A),
                contentColor = Color.White
            ),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("SAVED")
        }

        TextButton(
            onClick = onViewClick,
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFF08628A),
                contentColor = Color.White
            )
        ) {
            Text("View")
        }

        BannerAdView(true, AdSize.FULL_BANNER)
    }
}





