package com.example.fitnessapp.feature_app.presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.BottomAppBar
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController, vm: HomeVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(HomeEvent.GetName)
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(top = 40.dp)
                .fillMaxWidth()) {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Добро пожаловать,",
                            color = colorResource(R.color.targetBox),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = montserratRegular
                        )
                        Text(text = state.name,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontFamily = montserratBold,
                            fontWeight = FontWeight(700),
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    IconButton(onClick = {

                    },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)) {
                        Icon(painter = painterResource(R.drawable.notification_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(40.dp, 42.dp))
                    }
                }
                LazyColumn(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()) {
                    item {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.endGradient),
                                    colorResource(R.color.startGradient)
                                )
                            ),
                                shape = RoundedCornerShape(22.dp))){
                                Row(modifier = Modifier
                                    .padding(start = 20.dp)
                                    .padding(top = 26.dp)) {
                                    Column {
                                        Text(
                                            text = "ИМТ (индекс массы тела)",
                                            color = Color.White,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight(600),
                                            fontFamily = montserratRegular
                                        )
                                        Text(
                                            text = "У тебя нормальный вес",
                                            color = Color.White,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = montserratRegular,
                                            modifier = Modifier
                                                .padding(top = 5.dp)
                                        )
                                        Button(
                                            onClick = {

                                            },
                                            modifier = Modifier
                                                .padding(top = 15.dp)
                                                .padding(bottom = 26.dp)
                                                .background(
                                                    Brush.horizontalGradient(
                                                        colors = listOf(
                                                            colorResource(R.color.buttonGrStart),
                                                            colorResource(R.color.buttonGrEnd)
                                                        )
                                                    ),
                                                    shape = RoundedCornerShape(50.dp)
                                                ),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = Color.White
                                            )
                                        ) {
                                            Text(
                                                text = "Больше",
                                                color = Color.White,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight(600),
                                                fontFamily = montserratBold
                                            )
                                        }
                                    }
                                    Image(painter = painterResource(R.drawable.pie_chart),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(top = 3.dp))
                                }
                        }
                        Box(modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                            .background(Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.buttonGrEnd),
                                    colorResource(R.color.buttonGrStart)
                                )
                            ),
                                shape = RoundedCornerShape(100.dp),
                                alpha = 0.2f)){
                                Row(modifier = Modifier
                                    .padding(start = 20.dp)
                                    .padding(end = 14.dp)
                                    .padding(vertical = 22.dp)
                                    .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Text(text = "Сегодняшняя цель",
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(500),
                                        fontFamily = montserratRegular
                                   )
                                    Box(modifier = Modifier
                                        .background(color = colorResource(R.color.loginColor),
                                            shape = RoundedCornerShape(100.dp))
                                        .clickable {

                                        },
                                        contentAlignment = Alignment.Center){
                                        Text(text = "Проверить",
                                            color = Color.White,
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = montserratRegular
                                       )
                                    }
                                }
                        }
                        Text(text = "Статус активности",
                            color = Color.Black,
                            fontFamily = montserratBold,
                            fontWeight = FontWeight(600),
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(top = 30.dp)
                        )
                        Box(modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .background(Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.buttonGrEnd),
                                    colorResource(R.color.buttonGrStart)
                                )
                            ),
                                shape = RoundedCornerShape(20.dp),
                                alpha = 0.22f)){
                                Column(modifier = Modifier
                                    .padding(top = 24.dp)
                                    .padding(start = 20.dp)
                                    .padding(end = 16.dp)) {
                                    Text(text = "Частота сердечных сокращений",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontFamily = montserratRegular,
                                        fontWeight = FontWeight(500)
                                    )
                                    Image(painter = painterResource(R.drawable.barchart_home),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(top = 7.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Crop)
                                    Text(text = "78 BPM",
                                        color = colorResource(R.color.homeText),
                                        fontWeight = FontWeight(600),
                                        fontSize =  14.sp,
                                        fontFamily = montserratBold,
                                        modifier = Modifier
                                            .padding(top = 14.dp)
                                            .align(Alignment.CenterHorizontally)
                                   )
                                }
                        }
                        Row(modifier = Modifier
                            .padding(top = 21.dp)
                            .fillMaxWidth()) {
                                ElevatedCard(
                                    elevation = CardDefaults.elevatedCardElevation(
                                        defaultElevation = 10.dp
                                    ),
                                    shape = RoundedCornerShape(20.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White,
                                        contentColor = Color.Transparent
                                    ),
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(150.dp)
                                        .background(color = colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                            shape = RoundedCornerShape(20.dp))
                                ) {
                                    Column(modifier = Modifier
                                        .padding(top = 20.dp)
                                        .padding(start = 20.dp)) {
                                        Text(text = "Вода",
                                            color = Color.Black,
                                            fontSize = 12.sp,
                                            fontFamily = montserratRegular,
                                            fontWeight = FontWeight(500)
                                        )
                                        Text(text = "4 Литра",
                                            color = colorResource(R.color.homeText),
                                            fontSize = 14.sp,
                                            fontFamily = montserratBold,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(top = 5.dp))
                                        Text(text = "В реал. времени",
                                            color = colorResource(R.color.onBText),
                                            fontSize = 10.sp,
                                            fontFamily = montserratRegular,
                                            fontWeight = FontWeight(400),
                                            modifier = Modifier.padding(top = 10.dp)
                                                .padding(end = 13.dp))
                                    }
                                }
                            Spacer(modifier = Modifier.width(15.dp))
                            ElevatedCard(
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 10.dp
                                ),
                                shape = RoundedCornerShape(20.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Transparent
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(150.dp)
                                    .background(color = colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                        shape = RoundedCornerShape(20.dp))
                            ) {
                                Column(modifier = Modifier
                                    .padding(top = 20.dp)
                                    .padding(horizontal = 20.dp)) {
                                    Text(text = "Сон",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontFamily = montserratRegular,
                                        fontWeight = FontWeight(500)
                                    )
                                    Text(text = "Вода",
                                        color = colorResource(R.color.homeText),
                                        fontSize = 14.sp,
                                        fontFamily = montserratBold,
                                        fontWeight = FontWeight(600),
                                        modifier = Modifier.padding(top = 5.dp))
                                    Image(painter = painterResource(R.drawable.sleep_graph),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(top = 5.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Crop)
                                }
                            }
                        }
                    }
                    item{
                        Box(modifier = Modifier
                            .height(100.dp))
                    }
                }
            }
            if(state.error.isNotEmpty()){
                ErrorAlertDialog(state.error) {
                    vm.onEvent(HomeEvent.ClearError)
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomAppBar(navController, 1)
        }
    }
}