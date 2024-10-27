package com.example.myshopping.ui.theme.admob

import android.content.Context
import androidx.room.Room

object DatabaseInstance {
    @Volatile
    private var INSTANCE: ItemDatabase? = null

    fun getDatabase(context: Context): ItemDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                ItemDatabase::class.java,
                "item_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
