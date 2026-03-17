package com.example.practice11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    Practice1BoxLayout()
                }
            }
        }
    }
}

/**
 * Практика 1: Контейнер Box и фон для текста
 * Задача: Сделать так, чтобы каждый участок текста был залит фоном.
 */
@androidx.compose.runtime.Composable
fun Practice1BoxLayout() {
    // Box занимает всё доступное место (fillMaxSize)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Текст 1: Верхний левый угол (TopStart)
        Text(
            text = "Текст 1 (TopStart)",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart) // Выравнивание внутри Box
                .background(Color.Red)     // Заливка фоном (Практика 1)
                .padding(8.dp)             // Отступ внутри фона для красоты
        )

        // Текст 2: Центр (Center)
        Text(
            text = "Текст 2 (Center)",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Green)   // Заливка фоном
                .padding(8.dp)
        )

        // Текст 3: Нижний правый угол (BottomEnd)
        Text(
            text = "Текст 3 (BottomEnd)",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(Color.Blue)    // Заливка фоном
                .padding(8.dp)
        )

        // Текст 4: Пример с contentAlignment самого Box (если бы не было align у текста)
        // Но так как мы используем align у каждого текста, они игнорируют contentAlignment родителя
    }
}