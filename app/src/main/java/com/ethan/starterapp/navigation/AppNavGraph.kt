package com.ethan.starterapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ethan.starterapp.ui.screens.AddItemScreen
import com.ethan.starterapp.ui.screens.ChecklistScreen
import com.ethan.starterapp.ui.screens.MainScreen
import com.ethan.starterapp.ui.screens.SplashScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("main") { MainScreen(navController) }
        composable("add") { AddItemScreen(navController) }
        composable("checklist") { ChecklistScreen(navController) }
    }
}