@file:Suppress("UNUSED_EXPRESSION")

package com.example.fitnessapp.feature_app.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorAlertDialog(ex:String,
                     click: () -> Unit) {
    AlertDialog(onDismissRequest = click,
        confirmButton = {
            Button(onClick = {
                click
            }){
                Text("OK")
            }
        },
        title = {
            Text(text = "Ошибка")
        },
        text = {
            Text(text = ex)
        })
}