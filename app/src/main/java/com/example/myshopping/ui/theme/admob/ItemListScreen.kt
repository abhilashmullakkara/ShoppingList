package com.example.myshopping.ui.theme.admob

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ItemListScreen(itemViewModel: ItemViewModel = viewModel()) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val itemList by itemViewModel.allItems.collectAsStateWithLifecycle(lifecycleOwner.lifecycle)

    Column {
        Text("Saved Items",color=Color.LightGray,fontSize=14.sp,modifier=Modifier.padding(start=10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider()
        if (itemList.isEmpty()) {
            Text(text = "No items in the database", color = Color.Gray)
        } else {
            Spacer(modifier = Modifier.height(5.dp))
            itemList.forEachIndexed { index, item ->
                Row(modifier = Modifier.padding(start=8.dp)) {
                    Text(text = (index+1).toString(), modifier = Modifier
                        .padding(start = 5.dp)
                        .weight(0.15f),
                        color = Color.White, fontSize = 16.sp)
                    Text(
                        text = item.name,
                        color =  Color(0xFF01051B),
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(text = item.quantity,
                        modifier = Modifier.weight(0.15f),color =  Color(0xFF01051B), fontSize = 16.sp)
                    FloatingActionButton(
                        onClick = {
                            itemViewModel.deleteItem(item)
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
    }
}
