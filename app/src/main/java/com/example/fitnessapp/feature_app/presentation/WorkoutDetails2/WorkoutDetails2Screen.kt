package com.example.fitnessapp.feature_app.presentation.WorkoutDetails2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular

@Composable
fun WorkoutDetails2Screen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)){
            Column(modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(top = 40.dp)
                .fillMaxWidth()) {
                Row(modifier = Modifier
                    .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(painter = painterResource(R.drawable.back_icon),
                            contentDescription = null)
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(painter = painterResource(R.drawable.details_icon),
                            contentDescription = null)
                    }
                }
                Image(painter = painterResource(R.drawable.video),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Text(text = "Прыжки на скакалке",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = montserratBold,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Text(text = "Просто | 390 калорий",
                    color = colorResource(R.color.onBText),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular,
                    modifier = Modifier
                        .padding(top = 5.dp))
                Text(text = "Описание",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = montserratBold,
                    modifier = Modifier
                        .padding(top = 18.dp)
                )
                Text(text = "Джампинг-джек, также известный как звездный прыжок и называемый в армии США прыжком в сторону, представляет собой физическое прыжковое упражнение, выполняемое путем прыжка в положение с широко расставленными ногами. Прочитайте больше...",
                    color = colorResource(R.color.onBText),
                    fontSize = 12.sp,
                    fontFamily = montserratRegular,
                    fontWeight = FontWeight(500),
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Row(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text ="Как это сделать",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = montserratBold)
                    Text(text = "4 Подхода",
                        color = colorResource(R.color.onBText),
                        fontWeight = FontWeight(500),
                        fontSize = 12.sp,
                        fontFamily = montserratRegular
                    )
                }
            }
        }
    }
}