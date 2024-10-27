package com.example.myshopping.ui.theme.admob

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshopping.ui.theme.item.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    private val _allItems = MutableStateFlow<List<Item>>(emptyList())
    val allItems: StateFlow<List<Item>> = _allItems

    init {
        // Collect data from repository and update _allItems StateFlow
        viewModelScope.launch {
            repository.allItems.collect { items ->
                _allItems.value = items
                //Log.d("ItemViewModel", "Items in database: $items")
            }
        }
    }

    fun insertItem(item: Item) {
        viewModelScope.launch {
            repository.insert(item)
           // Log.d("ItemViewModel", "Inserted item: ${item.name}")
        }
    }

    fun updateItem(item: Item) {
        viewModelScope.launch {
            repository.update(item)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
}

