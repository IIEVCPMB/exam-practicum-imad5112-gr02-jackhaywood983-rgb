package com.ethan.starterapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewScreen : ViewModel() {
    // Parallel arrays
    val itemNames = mutableStateListOf("Tent", "Marshmallows", "Flashlight")
    val itemCategories = mutableStateListOf("Shelter", "Food", "Safety")
    val itemQuantities = mutableStateListOf(1, 3, 2)
    val itemComments = mutableStateListOf("4-person waterproof", "For S'mores (Mega size)", "Check batteries (AA)")

    fun getTotalItems(): Int {
        var total = 0
        for (i in itemQuantities.indices) {
            total += itemQuantities[i]
        }
        return total
    }
    fun addItem(name: String, category: String, qtyStr: String, comment: String): String {
        if (name.isBlank()) return "Item name cannot be empty"
        val qty = qtyStr.toIntOrNull()
        if (qty == null || qty <= 0) return "Quantity must be a number > 0"

        itemNames.add(name)
        itemCategories.add(category)
        itemQuantities.add(qty)
        itemComments.add(comment)
        return "success"
    }
}