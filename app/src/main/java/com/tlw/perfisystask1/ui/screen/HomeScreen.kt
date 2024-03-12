@file:OptIn(ExperimentalMaterial3Api::class)

package com.tlw.perfisystask1.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tlw.perfisystask1.R
import com.tlw.perfisystask1.model.UserSpent
import com.tlw.perfisystask1.ui.theme.BodyText
import com.tlw.perfisystask1.ui.theme.FavButton
import com.tlw.perfisystask1.ui.theme.HeadingText
import com.tlw.perfisystask1.ui.theme.HintText

@Composable
fun HomeScreen(navController: NavHostController) {
    MainUI()
}

@Composable
fun MainUI() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        val userSpentList by remember {
            mutableStateOf(mutableListOf(UserSpent(1, "Ashif", "200"), UserSpent(2, "Priti", "60")))
        }
        Spacer(modifier = Modifier.height(10.dp))
        ToolBar()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Monthly expenses tracker",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = HeadingText
        )

        Spacer(modifier = Modifier.height(30.dp))

        GridCard()
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(modifier = Modifier.fillMaxWidth(), text = "Spent by:", textAlign = TextAlign.Start, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = BodyText)

            for (userSpent in userSpentList){
                Spacer(modifier = Modifier.height(20.dp))
                Text(modifier = Modifier.fillMaxWidth(), text = "${userSpent.name}: ${userSpent.spent}", textAlign = TextAlign.Start, fontWeight = FontWeight.Normal, fontSize = 18.sp, color = HeadingText)
            }

            Spacer(modifier = Modifier.height(80.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )) {
                    Text(modifier = Modifier
                        .wrapContentWidth()
                        .padding(15.dp), text = "Show Expenses", textAlign = TextAlign.Start, fontWeight = FontWeight.Normal, fontSize = 20.sp, color = BodyText)
                }

                Card(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = CircleShape,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )){
                    Icon(
                        modifier = Modifier
                            .height(55.dp)
                            .aspectRatio(1f)
                            .padding(10.dp),
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null,
                        tint = FavButton
                    )
                }

            }
        }
    }
}

@Composable
fun GridCard() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
            .weight(1f)
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = modifier,
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    text = "This month",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = HintText
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .weight(1f),
                    text = "260",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = BodyText
                )
            }

        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = modifier,
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Past Price",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = BodyText
                )
            }

        }
    }
}

@Composable
fun HomeScreen() {
    MainUI()
}

@Composable
fun ToolBar() {
    val animatedLogo by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.game_controller)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
    ) {
        LottieAnimation(
            animatedLogo,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .padding(5.dp),
        )


        Icon(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .align(Alignment.CenterEnd)
                .padding(10.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen5() {
    HomeScreen()
}