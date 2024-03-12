package com.tlw.perfisystask1.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tlw.perfisystask1.model.GroupExpenseHistoryModel
import com.tlw.perfisystask1.ui.theme.BodyText
import com.tlw.perfisystask1.ui.theme.HeadingText
import com.tlw.perfisystask1.ui.theme.HintText

@Composable
fun ExpenseHistoryScreen(navController: NavHostController) {
    val expenseDataList by remember {
        mutableStateOf(
            mutableListOf(
                GroupExpenseHistoryModel(
                    1,
                    "Ashif",
                    "Grocery",
                    "260",
                    "12-03-2024 19:20"
                ),
                GroupExpenseHistoryModel(2, "Priti", "Beauty Product", "2160", "12-03-2024 20:16"),
                GroupExpenseHistoryModel(3, "Ashif", "Food", "510", "13-03-2024 11:30")
            )
        )
    }
    Column(Modifier.fillMaxSize()) {
        ToolBarTitle()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = "March 2024",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = BodyText
        )

        LazyColumn {
            items(expenseDataList.size, key = { expenseDataList[it].id }) { index ->
                val expenseData = expenseDataList[index]
                CustomHistoryCard(expenseData)
            }
        }
    }
}

@Composable
fun CustomHistoryCard(expenseData: GroupExpenseHistoryModel) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    text = "${expenseData.title}",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = BodyText
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    textAlign = TextAlign.End,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = HintText, fontSize = 16.sp)){
                            append("Rs")
                        }
                        withStyle(style = SpanStyle(color = HeadingText, fontSize = 20.sp, fontWeight = FontWeight.Bold)){
                            append(" ${expenseData.amount}")
                        }
                    },
                    fontSize = 20.sp,
                    color = BodyText,
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    text = "${expenseData.userName}",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = HintText
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    text = "${expenseData.dateTime}",
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = HintText
                )
            }
        }
    }
}

@Composable
fun ToolBarTitle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = "Expense History",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = BodyText
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen8() {
//    ExpenseHistoryScreen(navController)
}