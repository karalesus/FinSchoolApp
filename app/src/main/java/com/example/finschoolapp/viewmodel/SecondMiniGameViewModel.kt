package com.example.finschoolapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.finschoolapp.R

class SecondMiniGameViewModel : ViewModel() {
    val questions = listOf(
        SecondMiniGameQuestion(
            questionTitle = "Магазин",
            questionText = "Нужно купить продукты. Что купит Толик?",
            imageResId = R.drawable.second_mini_game_answer_image_shop,
            answers = listOf(
                "Газировка (70 р)",
                "Курица (250 р)",
                "Гречка (60 р)",
                "Чипсы (80 р)",
                "Лосось (500 р)"
            )
        ),
        SecondMiniGameQuestion(
            questionTitle = "Утро",
            questionText = "Будильник! Пора вставать на работу!",
            imageResId = R.drawable.second_mini_game_answer_image_morning,
            answers = listOf(
                "Встать", "Полежать ещё 10 минут"
            )
        ),
        SecondMiniGameQuestion(
            questionTitle = "Завтрак",
            questionText = "Толик выбирает, что поесть на завтрак",
            imageResId = R.drawable.second_mini_game_answer_image_breakfast,
            answers = listOf(
                "Приготовить еду из купленных продуктов", "Поесть в кафе рядом с работой"
            )
        ),
        SecondMiniGameQuestion(
            questionTitle = "На работу",
            questionText = "Как Толик поедет на работу?",
            imageResId = R.drawable.second_mini_game_answer_image_work,
            answers = listOf(
                "Поехать на велосипеде", "Автобус (50 р)", "Такси (500 р)"
            )
        ),
        SecondMiniGameQuestion(
            questionTitle = "Работа",
            questionText = "Надеюсь, я не опоздаю, начальник обещал меня уволить, если такое еще раз повторится...",
            imageResId = R.drawable.second_mini_game_answer_image_work_bicycle,
            answers = listOf(
                "Продолжить"
            )
        ),
        SecondMiniGameQuestion(
            questionTitle = "Работа",
            questionText = "На работе всё хорошо, пришло время обеда",
            imageResId = R.drawable.second_mini_game_answer_image_food,
            answers = listOf(
                "Поесть еду из дома", "Сходить в кафе (250 р)"
            )
        ),
        SecondMiniGameQuestion(
            questionTitle = "Вечер",
            questionText = "После работы хочется куда-то сходить..",
            imageResId = R.drawable.second_mini_game_answer_image_evening,
            answers = listOf(
                "Отправиться домой", "Сходить с коллегами в боулинг (1500 р)", "Сходить в кино (400 р)"
            )
        ),
    )

    var totalSpent = mutableStateOf(0)

    fun addToSpent(cost: Int) {
        totalSpent.value += cost * 20
    }

    fun resetSpent() {
        totalSpent.value = 0
    }

}

data class SecondMiniGameQuestion(
    val questionTitle: String,
    val questionText: String,
    val imageResId: Int,
    val answers: List<String>
)