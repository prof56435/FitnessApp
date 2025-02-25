package com.example.fitnessapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitnessapp.feature_app.presentation.Login.LoginScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthTest {
    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    private val correctEmail = "qwe@gmail.com"
    private val correctPassword = "password"
    private val incorrectEmail = "qwe"
    private val incorrectPassword = "pass"
    private val emailValidationUseCase: EmailValidationUseCase
    private val passwordValidationUseCase: PasswordValidationUseCase


    @Test
    fun emailValidationTest(){
        assert(emailValidationUseCase.invoke(correctEmail))
    }

    @Test
    fun passwordValidation(){
       assert(passwordValidationUseCase.invoke(correctPassword))
    }

    @Test
    fun alertDialogEmail(){
        rule.setContent {
            LoginScreen(rememberNavController())
        }
        rule.onNodeWithText("Почта").performTextInput(incorrectEmail)
        rule.onNodeWithText("Пароль").performTextInput(correctPassword)
        rule.onNodeWithText("Войти").performClick()
        rule.onNodeWithText("Некорректная почта").assertIsDisplayed()
    }

    @Test
    fun alertDialogPassword(){
        rule.setContent {
            LoginScreen(rememberNavController())
        }
        rule.onNodeWithText("Почта").performTextInput(correctEmail)
        rule.onNodeWithText("Пароль").performTextInput(incorrectPassword)
        rule.onNodeWithText("Войти").performClick()
        rule.onNodeWithText("Пароль должен содержать не менее 6 символов").assertIsDisplayed()
    }

    @Test
    fun successfulAuth(){
        rule.setContent {
            LoginScreen(rememberNavController())
        }
        rule.onNodeWithText("Почта").performTextInput(correctEmail)
        rule.onNodeWithText("Пароль").performTextInput(correctPassword)
        rule.onNodeWithText("Войти").performClick()
        rule.onNodeWithText("Ошибка").assertIsNotDisplayed()
    }

    @Test
    fun failedAuth(){
        rule.setContent {
            LoginScreen(rememberNavController())
        }
        rule.onNodeWithText("Почта").performTextInput(correctEmail)
        rule.onNodeWithText("Пароль").performTextInput(correctPassword)
        rule.onNodeWithText("Войти").performClick()
        rule.onNodeWithText("Ошибка").assertIsDisplayed()
    }
}