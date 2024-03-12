package com.example.firstcomposeapp.ui.routes

sealed class Screen(val route:String) {
    object HomeScreen: Screen("home_screen")
    object ShowExpensesScreen: Screen("show_expense_screen")
    object GroupExpensesScreen: Screen("group_expense_screen")
    object ExpenseHistoryScreen: Screen("expense_history_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg->
                append("/$arg")
            }
        }
    }
}