package com.ethan.starterapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ethan.starterapp.MainViewModel

@Composable
fun ChecklistScreen(navController: NavController, viewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F4C75))
            .padding(16.dp)
    ) {
        Text("Full Checklist", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(Modifier.height(16.dp))

        // Loop through parallel arrays
        LazyColumn {
            items(viewModel.itemNames.size) { i ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1B262C))
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(viewModel.itemNames[i], color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("Category: ${viewModel.itemCategories[i]}", color = Color(0xFFBBE1FA))
                        Text("Quantity: ${viewModel.itemQuantities[i]}", color = Color(0xFFBBE1FA))
                        Text("Comment: ${viewModel.itemComments[i]}", color = Color(0xFF3282B8), fontSize = 14.sp)
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3282B8)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Base", fontSize = 18.sp)
        }
    }
}