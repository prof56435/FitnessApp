package com.example.fitnessapp.feature_app.presentation.Login

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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

//Назначение: верстка экрана Login
//Дата: 25.02.2025
//Автор: Неробеев Алексей

@Composable
fun LoginScreen(navController: NavController, vm: LoginVM = koinViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)){
            Column(modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Привет,",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = montserratRegular
                )
                Text(text = "Добро пожаловать",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = montserratBold,
                    fontWeight = FontWeight(700)
                )
                OutlinedTextField(value = state.email,
                    onValueChange = {
                        vm.onEvent(LoginEvent.EnterEmail(it))
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
                        Icon(painter = painterResource(R.drawable.email_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    },
                    placeholder = {
                        Text(text = "Почта",
                            color = colorResource(R.color.placeHolder),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                       )
                    }
                )
                OutlinedTextField(value = state.password,
                    onValueChange = {
                        vm.onEvent(LoginEvent.EnterPassword(it))
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
                        Icon(painter = painterResource(R.drawable.lock_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    },
                    placeholder = {
                        Text(text = "Пароль",
                            color = colorResource(R.color.placeHolder),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            fontFamily = montserratRegular
                        )
                    },
                    visualTransformation = if(state.visual){PasswordVisualTransformation()} else VisualTransformation.None,
                    trailingIcon = {
                        Icon(painter = painterResource(R.drawable.hide_password),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clickable {
                                    vm.onEvent(LoginEvent.VisualChange)
                                })
                    }
                )
                Text(text = "Забыл пароль?",
                    color = colorResource(R.color.placeHolder),
                    fontSize = 12.sp,
                    fontFamily = montserratRegular,
                    fontWeight = FontWeight(500),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter){
                    Column(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(onClick = {
                            vm.onEvent(LoginEvent.Auth)
                        },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(R.color.startGradient),
                                        colorResource(R.color.endGradient)
                                    )
                                ),
                                    shape = RoundedCornerShape(99.dp)),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Transparent,
                                containerColor = Color.Transparent
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(painter = painterResource(R.drawable.login_inage),
                                    contentDescription = null,
                                    tint = Color.Unspecified)
                                Text(text = "Войти",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(700),
                                    fontFamily = montserratBold,
                                    modifier = Modifier
                                        .padding(start = 10.dp)
                                )
                            }
                        }
                        Image(painter = painterResource(R.drawable.or),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop)
                        Image(painter = painterResource(R.drawable.google_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 25.dp))
                        Row(modifier = Modifier
                            .padding(top = 25.dp)) {
                            Text(text = "Нет аккаунта? ",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular
                           )
                            Text(text = "Зарегистрироваться",
                                fontFamily = montserratRegular,
                                fontWeight = FontWeight(500),
                                color = colorResource(R.color.loginColor),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(NavRoutes.RegisterPage.route)
                                    }
                            )
                        }
                    }
                }
            }
            if(state.error.isNotEmpty()){
                ErrorAlertDialog(state.error) {
                    vm.onEvent(LoginEvent.ClearError)
                }
            }
        }
    }
}