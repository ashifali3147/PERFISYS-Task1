package com.tlw.perfisystask1.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.firstcomposeapp.ui.routes.Screen
import com.tlw.perfisystask1.ui.theme.BodyText

@Composable
fun GroupExpensesScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            ToolBarBack { navController.navigateUp() }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Expenses",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = BodyText
            )
        }

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter).offset(y = -20.dp)
                .clickable {
                        navController.navigate(Screen.ExpenseHistoryScreen.route)
                }, colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(15.dp),
                text = "Expenses History",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = BodyText
            )
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen7() {
//    GroupExpensesScreen(navController)
}