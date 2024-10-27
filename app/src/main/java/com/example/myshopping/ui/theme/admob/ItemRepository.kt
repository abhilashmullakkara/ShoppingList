package com.example.myshopping.ui.theme.admob

import com.example.myshopping.ui.theme.item.Item
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemDao: ItemDao) {
   val allItems: Flow<List<Item>> = itemDao.getAllItems()

    suspend fun insert(item: Item) {
        itemDao.insertItem(item)
    }

    suspend fun update(item: Item) {
        itemDao.updateItem(item)
    }

    suspend fun delete(item: Item) {
        itemDao.deleteItem(item)
    }
}
