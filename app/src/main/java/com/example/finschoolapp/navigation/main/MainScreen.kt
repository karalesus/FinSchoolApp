package com.example.finschoolapp.navigation.main

import androidx.compose.runtime.Immutable

@Immutable
sealed class MainScreen (val route: String) {
    object Progress: MainScreen("Progress")
    object Learning: MainScreen("Learning")
    object Wallet: MainScreen("Wallet")
}