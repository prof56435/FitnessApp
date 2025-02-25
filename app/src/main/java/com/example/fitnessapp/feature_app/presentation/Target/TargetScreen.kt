package com.example.fitnessapp.feature_app.presentation.Target

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.Login.LoginEvent
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular

@Composable
fun TargetScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Text(
                text = "Какова ваша цель?",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = montserratBold,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Это поможет нам подобрать\nдля вас лучшую программу.",
                color = colorResource(R.color.targetText),
                fontWeight = FontWeight(400),
                fontFamily = montserratRegular,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 90.dp)
                        .size(15.dp, 358.dp)
                        .background(
                            color = colorResource(R.color.targetBox),
                            shape = RoundedCornerShape(22.dp)
                        )
                        .offset(-5.dp)
                )
                Image(
                    painter = painterResource(R.drawable.target_card),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .padding(top = 90.dp)
                        .size(15.dp, 358.dp)
                        .background(
                            color = colorResource(R.color.targetBox),
                            shape = RoundedCornerShape(22.dp)
                        )
                        .offset(5.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                        shape = RoundedCornerShape(99.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Подтвердить",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = montserratBold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
        }
    }
}