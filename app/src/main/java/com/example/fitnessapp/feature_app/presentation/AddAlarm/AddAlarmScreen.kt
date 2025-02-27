package com.example.fitnessapp.feature_app.presentation.AddAlarm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.WorkoutDetails1.WorkoutDetails1Event
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddAlarmScreen(navController: NavController, vm: AddAlarmVM = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.SleepSchedule.route)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .padding(horizontal = 30.dp)
            ) {
                TopAppBar("Добавить часы", navController)
                OutlinedTextField(
                    value = state.sleep,
                    shape = RoundedCornerShape(16.dp),
                    onValueChange = {
                        vm.onEvent(AddAlarmEvent.EnterSleep(it))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.sleep_icon),
                            contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.arrow_profile),
                            contentDescription = null)
                    },
                    placeholder = {
                        Text(text = "Сон",
                            color = colorResource(R.color.onBText),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                OutlinedTextField(
                    value = state.hours,
                    onValueChange = {
                        vm.onEvent(AddAlarmEvent.EnterHours(it))
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.time_icon),
                            contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.arrow_profile),
                            contentDescription = null)
                    },
                    placeholder = {
                        Text(text = "Часов для сна",
                            color = colorResource(R.color.onBText),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                OutlinedTextField(
                    value = state.repeat,
                    onValueChange = {
                        vm.onEvent(AddAlarmEvent.EnterRepeat(it))
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.repeat),
                            contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.arrow_profile),
                            contentDescription = null)
                    },
                    placeholder = {
                        Text(text = "Повтор",
                            color = colorResource(R.color.onBText),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {
                        null
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.vibrate_icon),
                            contentDescription = null)
                    },
                    trailingIcon = {
                        Switch(checked = true,
                            onCheckedChange = null)
                    },
                    placeholder = {
                        Text(text = "Вибрировать при звуке",
                            color = colorResource(R.color.onBText),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter){
                    Button(
                        onClick = {
                            vm.onEvent(AddAlarmEvent.AddSleep)
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
                            text = "Добавить",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = montserratBold,
                            fontWeight = FontWeight(700)
                        )
                    }
                }
            }
            if(state.error.isNotEmpty()){
                ErrorAlertDialog(state.error) {
                    vm.onEvent(AddAlarmEvent.ClearError)
                }
            }
        }
    }
}