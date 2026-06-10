package com.ethan.starterapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import com.ethan.starterapp.MainViewModel
import com.ethan.starterapp.ui.theme.StarterAppTheme

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = viewModel()) {
    val total = viewModel.getTotalItems()
    MainContent(
        totalItems = total,
        onAddGearClick = { navController.navigate("add") },
        onViewChecklistClick = { navController.navigate("checklist") }
    )
}

@Composable
fun MainContent(
    totalItems: Int,
    onAddGearClick: () -> Unit,
    onViewChecklistClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F4C75))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Campsite Commander", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text("Total Items Packed: $totalItems", fontSize = 20.sp, color = Color(0xFFBBE1FA), modifier = Modifier.padding(top = 16.dp, bottom = 32.dp))

        Button(
            onClick = onAddGearClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3282B8)),
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
        ) {
            Text("Add Gear", fontSize = 18.sp)
        }

        Button(
            onClick = onViewChecklistClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B262C)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Checklist", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    StarterAppTheme {
        MainContent(
            totalItems = 5,
            onAddGearClick = {},
            onViewChecklistClick = {}
        )
    }
}
