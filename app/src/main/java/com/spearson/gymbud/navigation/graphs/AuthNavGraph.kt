package com.spearson.gymbud.navigation.graphs

import androidx.compose.animation.EnterTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController


import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.spearson.gymbud.presentation.auth.forgot_password.ForgotPasswordScreen
import com.spearson.gymbud.presentation.auth.login.LoginScreen
import com.spearson.gymbud.presentation.auth.sign_up.SignUpScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController, onLoginSuccess: () -> Unit) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route,
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onClick = onLoginSuccess,
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen()
        }
        composable(route = AuthScreen.Forgot.route) {
            ForgotPasswordScreen()
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}