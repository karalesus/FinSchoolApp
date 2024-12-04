package com.example.finschoolapp

import com.example.finschoolapp.network.ApiService
import com.example.finschoolapp.network.httpClientAndroid
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import com.example.finschoolapp.presentations.viewModels.ModuleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    viewModel { ModuleViewModel() }
    single { ApiService(get()) }
    viewModel { ArticleViewModel(get()) }
    single { httpClientAndroid }
}