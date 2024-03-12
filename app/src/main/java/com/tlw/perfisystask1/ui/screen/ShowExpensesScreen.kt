package com.tlw.perfisystask1.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShowExpensesScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        ToolBar()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen6() {
    ShowExpensesScreen()
}