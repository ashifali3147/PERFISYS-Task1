package com.tlw.perfisystask1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstcomposeapp.ui.routes.Screen
import com.tlw.perfisystask1.ui.screen.ExpenseHistoryScreen
import com.tlw.perfisystask1.ui.screen.GroupExpensesScreen
import com.tlw.perfisystask1.ui.screen.HomeScreen
import com.tlw.perfisystask1.ui.screen.ShowExpensesScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.ShowExpensesScreen.route) {
            ShowExpensesScreen(navController)
        }
        composable(route = Screen.GroupExpensesScreen.route) {
            GroupExpensesScreen(navController)
        }
        composable(route = Screen.ExpenseHistoryScreen.route) {
            ExpenseHistoryScreen(navController)
        }
    }
}

