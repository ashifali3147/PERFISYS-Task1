package com.tlw.perfisystask1.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tlw.perfisystask1.model.GroupExpenseHistoryModel
import com.tlw.perfisystask1.ui.theme.BodyText
import com.tlw.perfisystask1.ui.theme.HintText

@Composable
fun PersonalExpensesScreen() {
    val expenseDataList by remember {
        mutableStateOf(
            mutableListOf(
                GroupExpenseHistoryModel(
                    1,
                    "",
                    "Internet",
                    "249",
                    "11-03-2024 19:20"
                ),
                GroupExpenseHistoryModel(2, "", "Udemy", "599", "12-03-2024 08:16"),
                GroupExpenseHistoryModel(3, "", "Food", "90", "13-03-2024 11:30")
            )
        )
    }
    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Card(
                Modifier
                    .width(200.dp)
                    .height(150.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth().padding(10.dp).align(Alignment.TopStart),
                        text = "Rs.",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = HintText
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "938",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = BodyText
                    )
                }
            }
        }
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen10() {
    PersonalExpensesScreen()
}