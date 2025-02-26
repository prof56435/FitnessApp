package com.example.fitnessapp.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R

@Composable
fun BottomAppBar(navController: NavController, activityNumber: Int) {
    var home_icon = painterResource(R.drawable.home_icon)
    var camera_icon = painterResource(R.drawable.camera_icon)
    var profile_icon = painterResource(R.drawable.profile_icon)
    when(activityNumber){
        1 -> home_icon = painterResource(R.drawable.home_active)
        3 -> camera_icon = painterResource(R.drawable.camera_active)
        4 -> profile_icon = painterResource(R.drawable.profile_active)
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .background(Color.Transparent)){
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)){
            Row(modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier
                    .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {
                        if(activityNumber != 1){
                            navController.navigate(NavRoutes.Home.route)
                        }
                    }) {
                        Icon(painter = home_icon,
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(painter = painterResource(R.drawable.activity_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
                Spacer(modifier = Modifier
                    .width(60.dp))
                Row(modifier = Modifier
                    .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = {
                        if(activityNumber != 3){

                        }
                    }) {
                        Icon(painter = camera_icon,
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    IconButton(onClick = {
                        if(activityNumber != 4){
                            navController.navigate(NavRoutes.Profile.route)
                        }
                    }) {
                        Icon(painter = profile_icon,
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
            }
        }
        IconButton(onClick = {

        },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .background(Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.startGradient),
                        colorResource(R.color.endGradient)
                    )
                ),
                    shape = CircleShape),
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = Color.White,
                containerColor = Color.Transparent
            )) {
            Icon(painter = painterResource(R.drawable.search_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
    }
}