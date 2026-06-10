package com.ethan.starterapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val itemNames = mutableStateListOf("Tent", "Marshmallows", "Flashlight")
    val itemCategories = mutableStateListOf("Shelter", "Food", "Safety")
    val itemQuantities = mutableStateListOf(1, 3, 2)
    val itemComments = mutableStateListOf("4-person waterproof", "For S'mores (Mega size)", "Check batteries (AA)")

    fun getTotalItems(): Int {
        var total = 0
        for (qty in itemQuantities) {
            total += qty
        }
        return total
    }

    fun addItem(name: String, category: String, qty: Int, comment: String) {
        if (name.isNotBlank() && qty > 0) {
            itemNames.add(name)
            itemCategories.add(category)
            itemQuantities.add(qty)
            itemComments.add(comment)
        }
    }
}