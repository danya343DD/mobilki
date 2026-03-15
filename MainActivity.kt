package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {

                    PracticalWork10()
                }
            }
        }
    }
}

@Composable
fun PracticalWork10() {

    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Практическая работа 10", fontSize = 20.sp, color = Color.Black)


        Text("Задание 1 & 2: Порядок модификаторов и свой цвет", fontSize = 16.sp)


        val myColor = Color(0xFF6200EE)


        Text(
            text = "1. Фон -> Смещение",
            modifier = Modifier
                .background(myColor)
                .offset(x = 30.dp, y = 0.dp)
                .padding(bottom = 10.dp)
        )


        Text(
            text = "2. Смещение -> Фон",
            modifier = Modifier
                .offset(x = 30.dp, y = 0.dp)
                .background(Color.LightGray)
                .padding(bottom = 10.dp)
        )

        Divider()


        Text("Задание 3: Размер 3/4 контейнера", fontSize = 16.sp)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Gray)
        ) {
            Text(
                text = "Я занимаю 75% ширины",
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .background(Color.Green)
            )
        }

        Divider()


        Text("Задание 4: Настройка Padding", fontSize = 16.sp)

        Text(
            text = "Текст с отступами",
            modifier = Modifier
                .background(Color.Cyan)
                .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 10.dp) // Практика 4
        )

        Divider()


        Text("Задание 5: Border, Padding внутри, RoundedCorner", fontSize = 16.sp)

        Text(
            text = "Текст в рамке",
            modifier = Modifier

                .padding(10.dp)

                .border(
                    width = 2.dp,
                    color = Color.Red,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(Color.White)
        )

        Divider()


        Text("Задание 6: Кликер", fontSize = 16.sp)
        Text("Текущий счет: ${score}", fontSize = 24.sp, color = Color.Blue)

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Кликни меня (+5)",
                color = Color.DarkGray,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
                    .clickable {
                        score += 5
                    }
            )


            Text(
                text = "Фиксировать прибыль",
                color = Color.Red,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
                    .clickable {
                        score = 0
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticalWork10()
}
}