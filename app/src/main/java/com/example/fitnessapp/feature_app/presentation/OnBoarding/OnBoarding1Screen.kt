package com.example.fitnessapp.feature_app.presentation.OnBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular

@Composable
fun OnBoarding1Screen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Image(painter = painterResource(R.drawable.onb1_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = "Отслеживайте свою цель",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = montserratBold,
                modifier = Modifier.padding(start = 30.dp)
                    .padding(top = 24.dp)
            )
            Text(text = "Не волнуйтесь, если у вас возникли проблемы с определением ваших целей. Мы можем помочь вам определить ваши цели и отслеживать их.",
                color = colorResource(R.color.onBText),
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = montserratRegular,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 30.dp))
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd){
                IconButton(onClick = {

                },
                    modifier = Modifier
                        .padding(end = 35.dp)
                        .padding(bottom = 45.dp)
                        .size(50.dp)
                        .background(Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                            shape = CircleShape),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.Transparent,
                        containerColor = Color.Transparent
                    )) {
                    Icon(painter = painterResource(R.drawable.arrow_right),
                        contentDescription = null,
                        tint = Color.Unspecified)
                }
            }
        }
    }
}