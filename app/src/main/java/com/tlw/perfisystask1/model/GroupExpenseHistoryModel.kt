package com.tlw.perfisystask1.model

data class GroupExpenseHistoryModel(
    val id: Int,
    val userName: String = "",
    val title: String,
    val amount: String,
    val dateTime: String
)
