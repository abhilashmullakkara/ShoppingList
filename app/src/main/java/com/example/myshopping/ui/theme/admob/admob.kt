package com.example.myshopping.ui.theme.admob

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myshopping.R
import com.example.myshopping.ui.theme.item.Item
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlinx.coroutines.launch


@OptIn(InternalComposeApi::class)
@SuppressLint("VisibleForTests")
@Composable
@UiComposable
fun BannerAdView(
    isTest: Boolean = true,
    banner: AdSize = AdSize.BANNER
) {
    val unitId = if (isTest) stringResource(R.string.ad_mob_test_banner_id)
    else stringResource(R.string.ad_mob_banner_id)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        AndroidView(
            factory = { context ->
                AdView(context).apply {
                    setAdSize(banner)
                    adUnitId = unitId
                    loadAd(AdRequest.Builder().build())
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AddItemInput(
    onAddItem: (Item) -> Unit
) {
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    val nameFocusRequester = remember { FocusRequester() }
    val quantityFocusRequester = remember { FocusRequester() }
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBF5))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Add New Item",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50),
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TextField(
                    value = itemName,
                    onValueChange = { itemName = it },
                    label = { Text("Item Name", fontSize = 14.sp) },
                    modifier = Modifier
                        .weight(1f)
                        .focusRequester(nameFocusRequester),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFFFF9E6),
                        unfocusedContainerColor = Color(0xFFFFF9E6),
                        cursorColor = Color(0xFF08628A),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color(0xFF08628A),
                        unfocusedLabelColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            coroutineScope.launch {
                                quantityFocusRequester.requestFocus()
                            }
                        }
                    )
                )

                TextField(
                    value = itemQuantity,
                    onValueChange = { itemQuantity = it },
                    label = { Text("Unit", fontSize = 14.sp) },
                    modifier = Modifier
                        .weight(0.7f)
                        .focusRequester(quantityFocusRequester),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFFFF9E6),
                        unfocusedContainerColor = Color(0xFFFFF9E6),
                        cursorColor = Color(0xFF08628A),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color(0xFF08628A),
                        unfocusedLabelColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (itemName.isNotEmpty()) {
                                onAddItem(Item(name = itemName, quantity = itemQuantity))
                                itemName = ""
                                itemQuantity = ""
                                coroutineScope.launch {
                                    nameFocusRequester.requestFocus()
                                }
                            }
                        }
                    )
                )

                FloatingActionButton(
                    onClick = {
                        if (itemName.isNotEmpty()) {
                            onAddItem(Item(name = itemName, quantity = itemQuantity))
                            itemName = ""
                            itemQuantity = ""
                            coroutineScope.launch {
                                nameFocusRequester.requestFocus()
                            }
                        }
                    },
                    containerColor = Color(0xFF27AE60),
                    contentColor = Color.White,
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Item",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ShoppingListScreen() {
    Surface(color = Color(0xFFF5F6FA)) {
        val newItemList = remember { mutableStateListOf<Item>() }
        val context = LocalContext.current
        val itemViewModel = viewModel<ItemViewModel> {
            val database = DatabaseInstance.getDatabase(context)
            val repository = ItemRepository(database.itemDao())
            ItemViewModel(repository)
        }

        var showSavedItems by remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                SimpleTopAppBar()

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        AddItemInput(
                            onAddItem = { newItem ->
                                newItemList.add(newItem)
                            }
                        )
                    }

                    item {
                        if (newItemList.isNotEmpty()) {
                            NewItemListDisplay(newItemList, itemViewModel)
                        }

                        // Action Buttons
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Button(
                                    onClick = {
                                        if (newItemList.isNotEmpty()) {
                                            Toast.makeText(context, "Items Saved!", Toast.LENGTH_SHORT).show()
                                            newItemList.forEach { itemViewModel.insertItem(it) }
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27AE60)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                                ) {
//                                    Icon(
//                                        imageVector = Icons.Default.Check,
//                                        contentDescription = "Save",
//                                        modifier = Modifier.size(20.dp)
//                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Save", fontWeight = FontWeight.SemiBold)
                                }

                                Button(
                                    onClick = { showSavedItems = !showSavedItems },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF08628A)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                                ) {
//                                    Icon(
//                                        imageVector = Icons.Default.List,
//                                        contentDescription = "View",
//                                        modifier = Modifier.size(20.dp)
//                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("View", fontWeight = FontWeight.SemiBold)
                                }

                                Button(
                                    onClick = {
                                        newItemList.clear()
                                        showSavedItems = false
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE74C3C)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                                ) {
//                                    Icon(
//                                        imageVector = Icons.Default.DeleteSweep,
//                                        contentDescription = "Clear",
//                                        modifier = Modifier.size(20.dp)
//                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Clear", fontWeight = FontWeight.SemiBold)
                                }
                            }
                        }
                    }

                    item {
                        if (showSavedItems) {
                            SavedItemsDisplay(itemViewModel)
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        BannerAdView(isTest = false, banner = AdSize.FULL_BANNER)
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun NewItemListDisplay(newItemList: MutableList<Item>, itemViewModel: ItemViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Current Shopping List",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50),
                modifier = Modifier.padding(bottom = 12.dp)
            )

            newItemList.forEachIndexed { index, item ->
                itemViewModel.updateItem(item)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(
                                    color = Color(0xFF08628A),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${index + 1}",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.name,
                                color = Color(0xFF2C3E50),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            if (item.quantity.isNotEmpty()) {
                                Text(
                                    text = item.quantity,
                                    color = Color(0xFF7F8C8D),
                                    fontSize = 14.sp,
                                    modifier = Modifier.padding(top = 2.dp)
                                )
                            }
                        }

                        IconButton(
                            onClick = { newItemList.remove(item) },
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Color(0xFFFFEBEE),
                                    shape = CircleShape
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Remove",
                                tint = Color(0xFFE74C3C),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar() {
    val activity = LocalContext.current as? Activity

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = Color(0xFFFFC107),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "🛒",
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "My Shopping List",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF08628A),
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            actions = {
                IconButton(
                    onClick = { activity?.finish() }
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = Color(0xFFFFC107),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close App",
                            tint = Color(0xFF003F5E),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun SavedItemsDisplay(itemViewModel: ItemViewModel) {
    val savedItems = itemViewModel.allItems.collectAsState(initial = emptyList())

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header with icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = Color(0xFF4CAF50),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "✓",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Saved Items",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B5E20)
                    )
                    Text(
                        text = "${savedItems.value.size} items saved",
                        fontSize = 14.sp,
                        color = Color(0xFF558B2F)
                    )
                }
            }

            // Items list
            if (savedItems.value.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "📋",
                            fontSize = 48.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "No saved items yet",
                            fontSize = 16.sp,
                            color = Color(0xFF558B2F),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            } else {
                savedItems.value.forEachIndexed { index, item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Number badge with gradient effect
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        color = Color(0xFF4CAF50),
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${index + 1}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            // Item details
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.name,
                                    color = Color(0xFF1B5E20),
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 17.sp
                                )
                                if (item.quantity.isNotEmpty()) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(top = 4.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(6.dp)
                                                .background(
                                                    color = Color(0xFF81C784),
                                                    shape = CircleShape
                                                )
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = item.quantity,
                                            color = Color(0xFF558B2F),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                    }
                                }
                            }

                            // Delete button with hover effect
                            IconButton(
                                onClick = { itemViewModel.deleteItem(item) },
                                modifier = Modifier
                                    .size(42.dp)
                                    .background(
                                        color = Color(0xFFFFEBEE),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Remove Saved Item",
                                    tint = Color(0xFFE53935),
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    SimpleTopAppBar()
}