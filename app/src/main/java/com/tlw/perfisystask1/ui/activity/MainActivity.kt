package com.tlw.perfisystask1.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tlw.perfisystask1.R
import com.tlw.perfisystask1.ui.navigation.Navigation
import com.tlw.perfisystask1.ui.theme.PERFISYSTask1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
            ) {
                Navigation()
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    PERFISYSTask1Theme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Surface(
        color = Color.White, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Toolbar()
            Spacer(modifier = Modifier.height(20.dp))
            MonthlyExpensesTracker()
        }
    }
}

@Composable
fun Toolbar() {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
    ) {
        LottieAnimationView(
            modifier = Modifier.size(56.dp),
            resId = R.raw.game_controller,
        )
        Spacer(modifier = Modifier.weight(1f))
//        Icon(
//            painter = painterResource(id = R.drawable.ic_menu),
//            contentDescription = null,
//            modifier = Modifier.size(56.dp)
//        )
    }
}

@Composable
fun MonthlyExpensesTracker() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Monthly expenses tracker",
//            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 10.dp), color = Color.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            ExpenseCard(text = "This month", value = "260")
            ExpenseCard(text = "Past Prices", value = "")
        }
    }
}

@Composable
fun ExpenseCard(text: String, value: String) {
    Surface(
        shape = RoundedCornerShape(10.dp),
//        elevation = 10.dp,
        modifier = Modifier
//            .weight(1f)
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = text,
//                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = value,
//                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
        }
    }
}

@Composable
fun LottieAnimationView(modifier: Modifier = Modifier, resId: Int) {
    // Placeholder for LottieAnimationView
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}