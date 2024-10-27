package com.example.myshopping.ui.theme.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyFloatingActionButton() {
    Box(
        modifier = Modifier.fillMaxSize(0.8f),
        contentAlignment = Alignment.BottomEnd // Position the FAB at the bottom right
    ) {
        FloatingActionButton(
            onClick = { /* Action to perform */ },
            containerColor = Color(0xFF08628A)// Customize FAB color
        ) {
            Icon(
                imageVector = Icons.Default.Add, // Default icon for FAB
                contentDescription = "Add",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FABPreview() {
    MyFloatingActionButton()
}