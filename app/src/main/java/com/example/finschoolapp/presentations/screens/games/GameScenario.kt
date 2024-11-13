package com.example.finschoolapp.presentations.screens.games
import com.example.finschoolapp.R

data class GameScenario(
    val day:String,
    val situation: String,
    val question: String,
    val options: List<String>,
    val money: List<Int>,
    val correctOptionIndex: Int,
    val image:Int
)
val scenarios = listOf(
    GameScenario(
        day = "Понедельник",
        situation = "Друг Тома предлагает: «Пойдем, поработаем на автозаправке,  принадлежащей моему дяде,  будем стекла мыть машинам. Я там вчера 50 рублей заработал за 2 часа».",
        question = "Как поступить Тому?",
        options = listOf("Поработать", "Отказаться"),
        money = listOf(50, 0),
        correctOptionIndex = 0,
        image = R.drawable.image_character_lvl1_1

    ),
    GameScenario(
        day = "Вторник",
        situation = "Друг сообщает Тому, что играет на форексе: вкладываешь 20 рублей, получаешь через неделю 60 рублей. Гарантирует, что вернет деньги, многие уже заработали!",
        question = "Что сделать с оставшимися деньгами?",
        options = listOf("Сумма небольшая, согласиться!", "Отказаться"),
        money = listOf(-20, 0),
        correctOptionIndex = 0,
        image = R.drawable.image_character_lvl1_1
    ),

    GameScenario(
        day = "Среда",
        situation = "Том заметил очень ароматную пиццу на прилавке. Пицца стоит 50 рублей. На самом деле ему хочется разнообразия, хоть раз в неделю можно же себе позволить.",
        question = "Как поступить Тому?",
        options = listOf("Поесть пиццы", "Стандартный обед"),
        money = listOf(-20, 0),
        correctOptionIndex = 1,
        image = R.drawable.image_character_lvl1_1
    ),
    GameScenario(
        day = "Четверг",
        situation = "В подъезде Тому встретилась соседка. Она заговорила с ним и сообщила, что недавно родила ребенка и ей сейчас неудобно самой выносить мусор. Она предлагает ему ежедневно помогать ей с выносом мусора, обещает давать 10 рублей в день.",
        question = "Как поступить Тому?",
        options = listOf("Отказаться, стыдно носить мусор", "Согласиться","Помогать бесплатно"),
        money = listOf(0, 30, 0),
        correctOptionIndex = 1,
        image = R.drawable.image_character_lvl1_1
    ),
    GameScenario(
        day = "Пятница",
        situation = "Том вспомнил, что его друг должен был ему 20 рублей, обещал отдать через неделю. Прошло уже 2 недели, но он ничего не говорит - наверное, забыл. ",
        question = "Нужно ли Тому напомнить другу о долге?",
        options = listOf("Напомнить", "Отдаст потом"),
        money = listOf(20, 0),
        correctOptionIndex = 0,
        image = R.drawable.image_character_lvl1_1
    ),
    GameScenario(
        day = "Суббота",
        situation = "В соседнем доме, в подвале открылся квест «Пещера страха»: промо-предложение, только 3 дня в честь открытия 100 рублей за вход, потом будет 200 рублей. Друзья Тома собираются идти.",
        question = "Звучит как выгодное предложение.\nКак поступить Тому?",
        options = listOf("Пойти", "Отказаться"),
        money = listOf(-100, 0),
        correctOptionIndex = 1,
        image = R.drawable.image_character_lvl1_1
    ),
    GameScenario(
        day = "Воскресенье",
        situation = "Том видит киоск: «Беспроигрышная лотерея! Выигрывает каждый второй билетик! Выигрыш от 5 до 100 рублей!». Билетик стоит всего 5 рублей. На его глазах незнакомый мужчина купил билетик и выиграл 50 рублей. У Тома в кармане 25 рублей.",
        question = "Сколько билетиков купить Тому?",
        options = listOf("Не покупать", "Купить один", "Купить два","Купить три","Купить четыре", "Купить пять"),
        money = listOf( 0, -5, -10, -15, -20, -25),
        correctOptionIndex = 0,
        image = R.drawable.image_character_lvl1_1
    )
)