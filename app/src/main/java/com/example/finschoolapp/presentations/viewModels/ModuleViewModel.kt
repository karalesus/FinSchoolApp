package com.example.finschoolapp.presentations.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.finschoolapp.R
import com.example.finschoolapp.presentations.screens.slider.Module

class ModuleViewModel : ViewModel() {
    private val _modules = MutableLiveData<List<Module>>()
    val modules: LiveData<List<Module>> get() = _modules

    init {
        _modules.value = generateSampleModules()
    }

    private fun generateSampleModules(): List<Module> {
        return listOf(
            Module(
                id = 1,
                title = "Модуль 1: Доходы и расходы",
                description = "Узнаете о различных источниках доходов, поймете, как управлять своими финансами",
                image = R.drawable.ic_slider_module1
            ),
            Module(
                id = 2,
                title = "Модуль 2: Планирование бюджета",
                description = "Освоите навыки создания семейного бюджета, поймете преимущества финансового планирования, научитесь распределять свои финансы",
                image = R.drawable.ic_slider_module2_inactive
            ),
            Module(
                id = 3,
                title = "Модуль 3: Личные сбережения",
                description = "Изучите различные способы накопления сбережений, включая инвестиции и управление расходами, чтобы обеспечить финансовую стабильность в будущем",
                image = R.drawable.ic_slider_module3_inactive
            ),
            Module(
                id = 4,
                title = "Модуль 4: Кредитование",
                description = "Познакомьтесь с мирами кредитов и погашения кредита, узнайте, как выбирать правильный тип кредита и управлять своими финансовыми обязательствами",
                image = R.drawable.ic_slider_module4_inactive
            ),
            Module(
                id = 5,
                title = "Модуль 5: Инвестирование",
                description = "Разберетесь в понятии инвестиций, изучите различные виды и стратегии инвестирования, а также поймете, как оценивать риски и доходность",
                image = R.drawable.ic_slider_module5_inactive
            ),
            Module(
                id = 6,
                title = "Модуль 6: Страхование",
                description = "Освоите функции страхования и виды страховых продуктов, чтобы защитить свои финансы от различных рисков и неожиданных событий",
                image = R.drawable.ic_slider_module6_inactive
            ),
            Module(
                id = 7,
                title = "Модуль 7: Финансовая безопасность",
                description = "Поймете, что такое финансовые риски и как обеспечить свою финансовую безопасность, а также узнаете о методах борьбы с мошенничеством.",
                image = R.drawable.ic_slider_module7_inactive
            ),
            Module(
                id = 8,
                title = "Модуль 8: Защита прав потребителей",
                description = "Ознакомьтесь с правами потребителей при финансовых сделках и узнаете, как обеспечить собственные интересы при заключении договоров",
                image = R.drawable.ic_slider_module8_inactive
            )
        )
    }
}
