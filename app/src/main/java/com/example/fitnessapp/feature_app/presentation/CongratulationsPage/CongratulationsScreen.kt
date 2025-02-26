package com.example.fitnessapp.feature_app.presentation.CongratulationsPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular

@Composable
fun CongratulationsScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Image(painter = painterResource(R.drawable.congr_image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 65.dp)
                    .padding(horizontal = 60.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Column(modifier = Modifier
                .padding(top = 36.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Поздравляем, вы\nзавершили тренировку",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center
                )
                Text(text = "Упражнения – король, а питание – королева.\nОбъедините их, и вы получите королевство.\n" +
                        "-Джек Лаланн",
                    color = colorResource(R.color.congrColor),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 15.dp))
                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter){
                    Button(
                        onClick = {
                            navController.navigate(NavRoutes.Home.route)
                        },
                        modifier = Modifier
                            .padding(bottom = 40.dp)
                            .fillMaxWidth()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.buttonGrStart),
                                        colorResource(R.color.buttonGrEnd)
                                    )
                                ),
                                shape = RoundedCornerShape(99.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "Завершить",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = montserratBold,
                            fontWeight = FontWeight(700)
                        )
                    }
                }
            }
        }
    }
}