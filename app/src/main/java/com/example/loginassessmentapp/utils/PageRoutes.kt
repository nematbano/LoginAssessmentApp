package com.example.loginassessmentapp.utils

sealed class PageRoutes(val route: String) {
    data object LoginPage : PageRoutes("login_page")

    data object SecondPage : PageRoutes("second_page")

    data object ThirdPage : PageRoutes("third_page")
}