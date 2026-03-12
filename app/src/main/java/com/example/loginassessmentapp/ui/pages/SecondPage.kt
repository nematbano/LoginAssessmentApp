package com.example.loginassessmentapp.ui.pages

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginassessmentapp.utils.PageRoutes
import com.example.loginassessmentapp.R

@Composable
fun SecondPage(modifier: Modifier = Modifier, navController: NavController) {
    val activity = LocalActivity.current
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.test_text1))
        Button(onClick = { navController.navigate(PageRoutes.ThirdPage.route) }) {
            Text(
                stringResource(R.string.test_text)
            )
        }
        Button(onClick = { activity?.finish() }) { Text(stringResource(R.string.not_test_text)) }
    }
}