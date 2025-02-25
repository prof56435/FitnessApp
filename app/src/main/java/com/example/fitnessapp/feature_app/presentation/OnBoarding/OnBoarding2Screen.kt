package com.example.fitnessapp.feature_app.presentation.OnBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

//Назначение: верстка экрана OnBoarding2
//Дата: 25.02.2025
//Автор: Неробеев Алексей

@Composable
fun OnBoarding2Screen(navController: NavController, vm: OnBoardingVM = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.next) {
        if(state.next){
            vm.onEvent(OnBoardingEvent.SwipeNull)
            vm.onEvent(OnBoardingEvent.NotNext)
            navController.navigate(NavRoutes.OnBoard3.route)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .draggable(state = rememberDraggableState { onDelta ->
                vm.onEvent(OnBoardingEvent.SwipeChange(onDelta, 2))
            },
                orientation = Orientation.Horizontal)
        ) {
            Image(painter = painterResource(R.drawable.onb2_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = "Сжигай лишнее",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = montserratBold,
                modifier = Modifier.padding(start = 30.dp)
                    .padding(top = 24.dp)
            )
            Text(text = "Давайте продолжать заниматься, чтобы достичь своих целей, это больно только временно, если ты сдашься сейчас, тебе будет больно навсегда.",
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
                    vm.onEvent(OnBoardingEvent.GoNext(2))
                },
                    modifier = Modifier
                        .padding(end = 35.dp)
                        .padding(bottom = 45.dp)
                        .size(50.dp)
                        .background(
                            Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.startGradient),
                                colorResource(R.color.endGradient)
                            )
                        ),
                            shape = CircleShape
                        ),
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