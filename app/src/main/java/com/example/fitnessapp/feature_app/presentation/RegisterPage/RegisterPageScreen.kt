package com.example.fitnessapp.feature_app.presentation.RegisterPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.Login.LoginEvent
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterPageScreen(navController: NavController, vm: RegisterPageVM = koinViewModel()) {
    val state = vm.state.value
    LaunchedEffect(key1 = !state.isComplete) {
        if(state.isComplete){
            navController.navigate(NavRoutes.Home.route)
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
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Привет,",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular
                )
                Text(
                    text = "Создай аккаунт",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = montserratBold,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                OutlinedTextField(value = state.fio,
                    onValueChange = {
                        vm.onEvent(RegisterPageEvent.EnterFio(it))
                    },
                    shape = RoundedCornerShape(100.dp),
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
                        Icon(
                            painter = painterResource(R.drawable.fio_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    },
                    placeholder = {
                        Text(
                            text = "ФИО",
                            color = colorResource(R.color.placeHolder),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                OutlinedTextField(value = state.number,
                    onValueChange = {
                        vm.onEvent(RegisterPageEvent.EnterNumber(it))
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.phone_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Номер телефона",
                            color = colorResource(R.color.placeHolder),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                OutlinedTextField(value = state.email,
                    onValueChange = {
                        vm.onEvent(RegisterPageEvent.EnterEmail(it))
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.email_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Почта",
                            color = colorResource(R.color.placeHolder),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    }
                )
                OutlinedTextField(value = state.password,
                    onValueChange = {
                        vm.onEvent(RegisterPageEvent.EnterPassword(it))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.tfColor),
                        unfocusedContainerColor = colorResource(R.color.tfColor),
                        focusedBorderColor = colorResource(R.color.tfColor),
                        unfocusedBorderColor = colorResource(R.color.tfColor),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(100.dp),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.lock_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Пароль",
                            color = colorResource(R.color.placeHolder),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    },
                    visualTransformation = if (state.visual) {
                        PasswordVisualTransformation()
                    } else VisualTransformation.None,
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.hide_password),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clickable {
                                    vm.onEvent(RegisterPageEvent.VisualChange)
                                })
                    }
                )
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.Start)
                ) {
                    Checkbox(checked = state.check,
                        onCheckedChange = {
                            vm.onEvent(RegisterPageEvent.CheckChange)
                        })
                    Text(
                        text = "Продолжая, вы принимаете нашу Политику\nконфиденциальности и Условия использования.",
                        color = colorResource(R.color.placeHolder),
                        fontFamily = montserratRegular,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400),
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                vm.onEvent(RegisterPageEvent.SignUp)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(R.color.startGradient),
                                            colorResource(R.color.endGradient)
                                        )
                                    ),
                                    shape = RoundedCornerShape(99.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Transparent,
                                containerColor = Color.Transparent
                            )
                        ) {
                            Text(
                                text = "Зарегистрироваться",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                fontFamily = montserratBold,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.or),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(R.drawable.google_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 25.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 25.dp)
                        ) {
                            Text(
                                text = "Имеете уже аккаунт? ",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular
                            )
                            Text(text = "Войти",
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(500),
                                color = colorResource(R.color.loginColor),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(NavRoutes.Login.route)
                                    }
                            )
                        }
                    }
                }
            }
            if(state.error.isNotEmpty()){
                ErrorAlertDialog(state.error) {
                    vm.onEvent(RegisterPageEvent.ClearError)
                }
            }
        }
    }
}