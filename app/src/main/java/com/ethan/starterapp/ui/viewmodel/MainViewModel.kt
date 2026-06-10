package com.ethan.starterapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Parallel arrays as required by brief
    val itemNames = mutableStateListOf("Tent", "Marshmallows", "Flashlight")
    val itemCategories = mutableStateListOf("Shelter", "Food", "Safety")
    val itemQuantities = mutableStateListOf(1, 3, 2)
    val itemComments = mutableStateListOf("4-person waterproof", "For S'mores (Mega size)", "Check batteries (AA)")

    // Use loop to calculate total - for marks
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