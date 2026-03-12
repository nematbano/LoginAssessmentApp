package com.example.loginassessmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginassessmentapp.ui.pages.LoginPage
import com.example.loginassessmentapp.ui.pages.SecondPage
import com.example.loginassessmentapp.ui.pages.ThirdPage
import com.example.loginassessmentapp.utils.PageRoutes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppCompose()
        }
    }
}

@Composable
fun LoginAppCompose() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PageRoutes.LoginPage.route
    ) {
        composable(PageRoutes.LoginPage.route) {
            LoginPage(Modifier.fillMaxSize(), navController)
        }

        composable(PageRoutes.SecondPage.route) {
            SecondPage(Modifier.fillMaxSize(), navController)
        }

        composable(PageRoutes.ThirdPage.route) {
            ThirdPage(Modifier.fillMaxSize())
        }

    }
}
