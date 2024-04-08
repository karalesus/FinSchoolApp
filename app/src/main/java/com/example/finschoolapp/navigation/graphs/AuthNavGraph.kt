package com.example.finschoolapp.navigation.graphs

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.auth.ForgotPasswordScreen
import com.example.finschoolapp.presentations.screens.auth.LoginScreen
import com.example.finschoolapp.presentations.screens.auth.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    screenName: (String) -> Unit
) {
    navigation(
        route = RootScreen.AuthNavGraph.route,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(RootScreen.MainScreenGraph.route)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )
            screenName("Login")
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(name = AuthScreen.SignUp.route) {}
            screenName("Sign Up")
        }
        composable(route = AuthScreen.Forgot.route) {
            ForgotPasswordScreen(name = AuthScreen.Forgot.route) {}
            screenName("Forgot password")
        }
    }
}

@Immutable
sealed class AuthScreen(val route: String) {
    object Login: AuthScreen(route = "Login")
    object SignUp: AuthScreen(route = "SignUp")
    object Forgot: AuthScreen(route = "ForgotPassword")
}