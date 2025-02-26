package com.example.fitnessapp.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.onFocusedBoundsChanged
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.Target.TargetScreen

@Composable
fun TopAppBar(name: String, navController: NavController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(painter = painterResource(R.drawable.back_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
        Text(text = name,
            color = Color.Black,
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            fontFamily = montserratBold
        )
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(painter = painterResource(R.drawable.details_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
    }
}