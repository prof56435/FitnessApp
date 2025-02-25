package com.example.fitnessapp.feature_app.presentation.SuccessRegistration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.montserratBold


@Composable
fun SuccessRegistrationScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Image(painter = painterResource(R.drawable.success_image),
                contentDescription = null,
                modifier = Modifier.padding(top = 102.dp)
                    .padding(vertical = 49.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = "Добро пожаловать, \n" +
                    "Стефани",
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = montserratBold)
            Button(onClick = {
                navController.navigate(NavRoutes.Home.route)
            }) { }
        }
    }
}