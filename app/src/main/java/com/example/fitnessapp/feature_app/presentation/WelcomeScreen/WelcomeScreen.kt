package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

//Назначение: верстка экрана WelcomeScreen
//Дата: 25.02.2025
//Автор: Неробеев Алексей

@Composable
fun WelcomeScreen(navController: NavController, vm: WelcomeVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(WelcomeEvent.GetPref)
    vm.onEvent(WelcomeEvent.GoNext)
    LaunchedEffect(key1 = !state.next) {
         if(state.next){
            when(state.onBNumber){
                0 ->{
                    navController.navigate(NavRoutes.OnBoard1.route)
                    vm.onEvent(WelcomeEvent.SavePref)
                }
                1 -> {
                    navController.navigate(NavRoutes.OnBoard2.route)
                    vm.onEvent(WelcomeEvent.SavePref)
                }
                2 -> {
                    navController.navigate(NavRoutes.OnBoard3.route)
                    vm.onEvent(WelcomeEvent.SavePref)
                }
                3 -> {
                    navController.navigate(NavRoutes.OnBoard4.route)
                    vm.onEvent(WelcomeEvent.SavePref)
                }
            }
        }
        if(state.onBNumber >= 4){
            navController.navigate(NavRoutes.Login.route)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)){
            Image(painter = painterResource(R.drawable.app_image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 83.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Row(modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.CenterHorizontally)){
                Text(text = "Wild",
                    color = colorResource(R.color.welcomestart),
                    fontSize = 36.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700)
                )
                Text(text = "Way",
                    color = Color.Black,
                    fontSize = 36.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700))
            }
            Text(text = "Каждый может тренироваться",
                color = colorResource(R.color.welcomeText),
                fontFamily = montserratRegular,
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

    }
}