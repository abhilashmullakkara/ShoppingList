package com.example.myshopping.ui.theme.item
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val name: String,
    val quantity: String
)

