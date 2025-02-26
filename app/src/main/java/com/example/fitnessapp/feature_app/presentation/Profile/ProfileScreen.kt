package com.example.fitnessapp.feature_app.presentation.Profile

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.BottomAppBar
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import com.example.fitnessapp.feature_app.presentation.common.poppinsRegular
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(navController: NavController, vm: ProfileVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(ProfileEvent.GetProfile)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier.padding(horizontal = 30.dp)
                .padding(top = 40.dp)
                .fillMaxWidth()) {
                TopAppBar("Профиль", navController)
                Row(modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()) {
                    Icon(painter = painterResource(R.drawable.profile_avatar),
                        contentDescription = null,
                        tint = Color.Unspecified)
                    Column(modifier = Modifier
                        .padding(start = 15.dp)) {
                        Text(text = state.name,
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = montserratRegular
                        )
                        Text(text = state.target,
                            color = colorResource(R.color.onBText),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = montserratRegular)
                    }
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd) {
                        Box(
                            modifier = Modifier
                                .size(95.dp, 30.dp)
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.buttonGrStart),
                                            colorResource(R.color.buttonGrEnd)
                                        )
                                    ),
                                    shape = RoundedCornerShape(99.dp)
                                )
                                .clickable {

                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Изменить",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(500)
                            )
                        }
                    }
                }
                Row(modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()) {
                    ElevatedCard(
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 10.dp
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .background(colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                shape = RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier
                            .padding(top = 11.dp)
                            .padding(bottom = 10.dp)
                            .align(Alignment.CenterHorizontally),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = state.height.toString(),
                                color = colorResource(R.color.homeText),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = poppinsRegular
                           )
                            Text(text = "Рост",
                                color = colorResource(R.color.onBText),
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                fontFamily = poppinsRegular,
                                modifier = Modifier
                                    .padding(top = 5.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    ElevatedCard(
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 10.dp
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .background(colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                shape = RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier
                            .padding(top = 11.dp)
                            .padding(bottom = 10.dp)
                            .align(Alignment.CenterHorizontally),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = state.weight.toString(),
                                color = colorResource(R.color.homeText),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = poppinsRegular
                            )
                            Text(text = "Рост",
                                color = colorResource(R.color.onBText),
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                fontFamily = poppinsRegular,
                                modifier = Modifier
                                    .padding(top = 5.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    ElevatedCard(
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 10.dp
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .background(colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                shape = RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier
                            .padding(top = 11.dp)
                            .padding(bottom = 10.dp)
                            .align(Alignment.CenterHorizontally),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = state.years.toString(),
                                color = colorResource(R.color.homeText),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = poppinsRegular
                            )
                            Text(text = "Рост",
                                color = colorResource(R.color.onBText),
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                fontFamily = poppinsRegular,
                                modifier = Modifier
                                    .padding(top = 5.dp))
                        }
                    }
                }
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()) {
                    item {
                        ElevatedCard(
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            modifier = Modifier
                                .padding(top = 30.dp)
                                .background(colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                    shape = RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(modifier = Modifier
                                .padding(top = 20.dp)
                                .padding(start = 20.dp)) {
                                Text(text = "Аккаунт",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(600)
                                )
                                Row(modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(top = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.profilecolor_icon),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                    Text(text = "Данные аккаунта",
                                        color = colorResource(R.color.onBText),
                                        fontSize = 12.sp,
                                        fontFamily = poppinsRegular,
                                        fontWeight = FontWeight(400),
                                        modifier = Modifier.padding(start = 10.dp))
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Icon(painter = painterResource(R.drawable.arrow_profile),
                                            contentDescription = null,
                                            tint = Color.Unspecified)
                                    }
                                }
                                Row(modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(top = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.achievement),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                    Text(text = "Достижения",
                                        color = colorResource(R.color.onBText),
                                        fontSize = 12.sp,
                                        fontFamily = poppinsRegular,
                                        fontWeight = FontWeight(400),
                                        modifier = Modifier.padding(start = 10.dp))
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Icon(painter = painterResource(R.drawable.arrow_profile),
                                            contentDescription = null,
                                            tint = Color.Unspecified)
                                    }
                                }
                                Row(modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(top = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.activity_profile),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                    Text(text = "История активности",
                                        color = colorResource(R.color.onBText),
                                        fontSize = 12.sp,
                                        fontFamily = poppinsRegular,
                                        fontWeight = FontWeight(400),
                                        modifier = Modifier.padding(start = 10.dp))
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Icon(painter = painterResource(R.drawable.arrow_profile),
                                            contentDescription = null,
                                            tint = Color.Unspecified)
                                    }
                                }
                                Row(modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(top = 10.dp)
                                    .padding(bottom = 20.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.statistic),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                    Text(text = "Прогресс занятий",
                                        color = colorResource(R.color.onBText),
                                        fontSize = 12.sp,
                                        fontFamily = poppinsRegular,
                                        fontWeight = FontWeight(400),
                                        modifier = Modifier.padding(start = 10.dp))
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Icon(painter = painterResource(R.drawable.arrow_profile),
                                            contentDescription = null,
                                            tint = Color.Unspecified)
                                    }
                                }
                            }
                        }
                        ElevatedCard(
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .background(colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                    shape = RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(modifier = Modifier
                                .padding(top = 20.dp)
                                .padding(start = 20.dp)) {
                                Text(text = "Уведомления",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(600)
                                )
                                Row(modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(top = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.notif_profile),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                    Text(text = "Данные аккаунта",
                                        color = colorResource(R.color.onBText),
                                        fontSize = 12.sp,
                                        fontFamily = poppinsRegular,
                                        fontWeight = FontWeight(400),
                                        modifier = Modifier.padding(start = 10.dp))
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Icon(painter = painterResource(R.drawable.arrow_profile),
                                            contentDescription = null,
                                            tint = Color.Unspecified)
                                    }
                                }
                            }
                        }
                        ElevatedCard(
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .background(colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                    shape = RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(modifier = Modifier
                                .padding(top = 20.dp)
                                .padding(start = 20.dp)) {
                                Text(text = "Остальное",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontFamily = montserratBold,
                                    fontWeight = FontWeight(600)
                                )
                                Row(modifier = Modifier
                                    .padding(end = 15.dp)
                                    .padding(top = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.contact_profile),
                                        contentDescription = null,
                                        tint = Color.Unspecified)
                                    Text(text = "Контакты",
                                        color = colorResource(R.color.onBText),
                                        fontSize = 12.sp,
                                        fontFamily = poppinsRegular,
                                        fontWeight = FontWeight(400),
                                        modifier = Modifier.padding(start = 10.dp))
                                    Box(modifier = Modifier
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd){
                                        Icon(painter = painterResource(R.drawable.arrow_profile),
                                            contentDescription = null,
                                            tint = Color.Unspecified)
                                    }
                                }
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .height(100.dp))
                    }
                }
            }
            if(state.error.isNotEmpty()){
                ErrorAlertDialog(state.error) {
                    vm.onEvent(ProfileEvent.ClearError)
                }
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter){
                BottomAppBar(navController, 4)
            }
        }
    }
}