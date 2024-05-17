package com.example.finschoolapp.navigation.graphs

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.auth.ConfirmationScreen
import com.example.finschoolapp.presentations.screens.auth.ForgotPasswordEnterCodeScreen
import com.example.finschoolapp.presentations.screens.auth.ForgotPasswordScreen
import com.example.finschoolapp.presentations.screens.auth.Hello
import com.example.finschoolapp.presentations.screens.auth.LoginScreen
import com.example.finschoolapp.presentations.screens.auth.NewPasswordScreen
import com.example.finschoolapp.presentations.screens.auth.SignUpScreen
import com.example.finschoolapp.presentations.screens.auth.SuccessfulRegistrationScreen
import com.example.finschoolapp.presentations.screens.auth.Welcome

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
            SignUpScreen(
                onNextClick = {
                navController.navigate(AuthScreen.Confirm.route)
            },
                onLoginClick =  {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
            screenName("Sign Up")
        }
        composable(route = AuthScreen.Confirm.route){
            ConfirmationScreen(onConfirmClick = { navController.navigate(AuthScreen.LetsStudy.route) })
            screenName("Confirm")
        }

        composable(route = AuthScreen.LetsStudy.route){
            SuccessfulRegistrationScreen(onLetsStudy = {
                navController.navigate(AuthScreen.Hello.route)
            })
            screenName("Lets Study")
        }
        composable(route = AuthScreen.Forgot.route) {
            ForgotPasswordScreen(
                onEnterClick = {
                    navController.navigate(AuthScreen.EnterCode.route)
                               },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                                },
                onReturnToMainClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
            screenName("Forgot password")
        }
        composable(route = AuthScreen.EnterCode.route) {
            ForgotPasswordEnterCodeScreen(
                onConfirmClick = {
                    navController.navigate(AuthScreen.NewPassword.route)
                                 },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                })
            screenName("Enter code")
        }
        composable(route = AuthScreen.NewPassword.route) {
            NewPasswordScreen(
                onSaveAndEnterOn = {
                navController.popBackStack()
                navController.navigate(RootScreen.MainScreenGraph.route)},
                onReturnToMainClick ={navController.navigate(AuthScreen.Login.route)})
            screenName("New password")
        }
        composable(route = AuthScreen.Hello.route){
            Hello(
                onWhatToDoClick = {
                navController.navigate(AuthScreen.Welcome.route)
            })
            screenName("Hello")
        }
        composable(route = AuthScreen.Welcome.route){
            Welcome(
                onIHelpYouClick = {
                    navController.popBackStack()
                    navController.navigate(RootScreen.MainScreenGraph.route)}
            )
            screenName("Welcome")
        }
    }
}

@Immutable
sealed class AuthScreen(val route: String) {
    object Login: AuthScreen(route = "Login")
    object SignUp: AuthScreen(route = "SignUp")
    object Forgot: AuthScreen(route = "ForgotPassword")
    object EnterCode: AuthScreen(route = "EnterCode")
    object NewPassword: AuthScreen(route = "NewPassword")
    object Confirm: AuthScreen(route = "Confirm")
    object LetsStudy: AuthScreen(route = "LetsStudy")
    object Hello: AuthScreen(route = "Hello")
    object Welcome: AuthScreen(route = "Welcome")

}