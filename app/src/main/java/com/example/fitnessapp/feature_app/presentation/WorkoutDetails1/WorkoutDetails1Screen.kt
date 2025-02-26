package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutDetails1Screen(navController: NavController, vm: WorkoutDetails1VM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(WorkoutDetails1Event.GetWorkout)
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.CongratulationPage.route)
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.buttonGrEnd),
                                colorResource(R.color.buttonGrStart)
                            )
                        )
                    )
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.back_icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.details_icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    }
                    Image(
                        painter = painterResource(R.drawable.workdet1_image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = 366.dp)
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(40.dp)
                        ),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)
                                .size(50.dp, 5.dp)
                                .background(
                                    color = Color.Black.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(50.dp)
                                )
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = state.name,
                                    color = Color.Black,
                                    fontWeight = FontWeight(700),
                                    fontSize = 16.sp,
                                    fontFamily = montserratBold
                                )
                                Text(
                                    text = state.description,
                                    color = colorResource(R.color.onBText),
                                    fontFamily = montserratRegular,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    modifier = Modifier
                                        .padding(top = 5.dp)
                                )
                            }
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.love_icon),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth()
                                .background(
                                    color = colorResource(R.color.workDetBox),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 15.dp)
                                    .padding(vertical = 14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.calendar_icon),
                                    contentDescription = null
                                )
                                Text(
                                    text = "Время тренировки",
                                    color = colorResource(R.color.homeText),
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(start = 10.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 17.dp),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = "27 мая, 09:00",
                                            color = colorResource(R.color.homeText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 10.sp,
                                            fontFamily = montserratRegular
                                        )
                                        Icon(
                                            painter = painterResource(R.drawable.icon_more),
                                            contentDescription = null,
                                            tint = Color.Unspecified,
                                            modifier = Modifier.padding(start = 10.dp)
                                        )
                                    }
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                                .background(
                                    color = colorResource(R.color.workDetBox),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 15.dp)
                                    .padding(vertical = 14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.diff_icon),
                                    contentDescription = null
                                )
                                Text(
                                    text = "Сложность",
                                    color = colorResource(R.color.homeText),
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(start = 10.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 17.dp),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = state.hard,
                                            color = colorResource(R.color.homeText),
                                            fontWeight = FontWeight(400),
                                            fontSize = 10.sp,
                                            fontFamily = montserratRegular
                                        )
                                        Icon(
                                            painter = painterResource(R.drawable.icon_more),
                                            contentDescription = null,
                                            tint = Color.Unspecified,
                                            modifier = Modifier.padding(start = 10.dp)
                                        )
                                    }
                                }
                            }
                        }
                        LazyColumn(
                            modifier = Modifier
                                .padding(top = 30.dp)
                                .fillMaxWidth()
                        ) {
                            item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Вам понадобится",
                                color = Color.Black,
                                fontWeight = FontWeight(600),
                                fontSize = 16.sp,
                                fontFamily = montserratBold
                            )
                            Text(
                                text = "5 предметов",
                                color = colorResource(R.color.targetBox),
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                fontFamily = montserratRegular
                            )
                        }
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                        ) {
                            item {
                                Column(
                                    modifier = Modifier
                                        .padding(end = 15.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(130.dp)
                                            .background(
                                                color = colorResource(R.color.tfColor),
                                                shape = RoundedCornerShape(12.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.barbel),
                                            contentDescription = null
                                        )
                                    }
                                    Text(
                                        text = "Гантели",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = montserratRegular,
                                        modifier = Modifier.padding(top = 10.dp)
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(end = 15.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(130.dp)
                                            .background(
                                                color = colorResource(R.color.tfColor),
                                                shape = RoundedCornerShape(12.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.skipping_rope),
                                            contentDescription = null
                                        )
                                    }
                                    Text(
                                        text = "Скакалка",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = montserratRegular,
                                        modifier = Modifier.padding(top = 10.dp)
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(end = 15.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(130.dp)
                                            .background(
                                                color = colorResource(R.color.tfColor),
                                                shape = RoundedCornerShape(12.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.baseline_battery_full_24),
                                            contentDescription = null
                                        )
                                    }
                                    Text(
                                        text = "Бутылка",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = montserratRegular,
                                        modifier = Modifier.padding(top = 10.dp)
                                    )
                                }
                            }
                        }

                                Row(
                                    modifier = Modifier
                                        .padding(top = 30.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Упражнения",
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontFamily = montserratBold,
                                        fontWeight = FontWeight(600)
                                    )
                                    Text(
                                        text = "3 подхода",
                                        color = colorResource(R.color.targetBox),
                                        fontWeight = FontWeight(500),
                                        fontFamily = montserratRegular,
                                        fontSize = 12.sp
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(top = 20.dp)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Подход 1",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontFamily = montserratRegular,
                                        fontWeight = FontWeight(500)
                                    )
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.run),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Бег",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "05:00",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.jump),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Прыжки",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "12x",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.skip),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Скакалка",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "15x",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.down),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Приседания",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "20x",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.hands_up),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Подъемы рук",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "00:53",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.chill),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Отдых и напитки",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "02:00",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Text(text = "Отжимания на наклоне",
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(500),
                                        fontFamily = montserratRegular,
                                        modifier = Modifier
                                            .padding(top = 20.dp)
                                   )
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.otzh_n),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Отжимания на наклоне",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "12x",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.otzh),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Отжимания",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "15x",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 15.dp)
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clickable {
                                                navController.navigate(NavRoutes.WorkoutDetails2.route)
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.skip),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                        ) {
                                            Text(
                                                text = "Скакалка",
                                                color = Color.Black,
                                                fontWeight = FontWeight(500),
                                                fontSize = 14.sp,
                                                fontFamily = montserratRegular
                                            )
                                            Text(
                                                text = "15x",
                                                fontFamily = montserratRegular,
                                                fontWeight = FontWeight(500),
                                                fontSize = 12.sp,
                                                modifier = Modifier
                                                    .padding(top = 5.dp)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.workout_right_circle),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                }
                            }
                            item {
                                Box(modifier = Modifier.height(500.dp))
                            }
                        }
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        onClick = {
                            vm.onEvent(WorkoutDetails1Event.CompleteWorkout)
                        },
                        modifier = Modifier
                            .padding(bottom = 40.dp)
                            .padding(horizontal = 30.dp)
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
                            text = "Начать",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = montserratBold,
                            fontWeight = FontWeight(700)
                        )
                    }
                }
                if (state.error.isNotEmpty()){
                    ErrorAlertDialog(state.error) {
                        vm.onEvent(WorkoutDetails1Event.ClearError)
                    }
                }
            }
        }
    }
}