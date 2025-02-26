package com.example.fitnessapp.feature_app.presentation.WorkoutTracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular

@Composable
fun WorkoutTrackerScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center){
        Column(modifier = Modifier
            .padding(horizontal = 30.dp)) {
            Text(text = "Что вы хотите тренировать",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = montserratBold,
                fontWeight = FontWeight(600)
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.buttonGrStart).copy(alpha = 0.2f))){
                Column {
                    Text(
                        text = "Все тело",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = montserratRegular,
                        fontWeight = FontWeight(500)
                    )
                    Text(
                        text = "11 упражнений | 32 минут",
                        color = colorResource(R.color.onBText),
                        fontSize = 12.sp,
                        fontFamily = montserratRegular,
                        fontWeight = FontWeight(400)
                    )
                    Button(
                        onClick = {
                            navController.navigate(NavRoutes.WorkoutDet1.route)
                        },
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .background(Color.White)
                    ) {
                        Text(text = "Больше")
                    }
                }
            }
        }
    }
}