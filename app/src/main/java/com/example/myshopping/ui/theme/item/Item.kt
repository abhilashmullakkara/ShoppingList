package com.example.myshopping.ui.theme.item
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Keep
//
//@Entity
//data class Item(
//    @PrimaryKey var id: Int = 0,
//    val name: String,
//    val quantity: String
//)

@Entity
data class Item(
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    val name: String,
    val quantity: String
)
