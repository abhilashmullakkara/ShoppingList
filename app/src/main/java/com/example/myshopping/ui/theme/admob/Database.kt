package com.example.myshopping.ui.theme.admob

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myshopping.ui.theme.item.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
