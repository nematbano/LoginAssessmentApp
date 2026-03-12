package com.example.loginassessmentapp.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.loginassessmentapp.LoginViewModel
import com.example.loginassessmentapp.utils.PageRoutes
import com.example.loginassessmentapp.R
import com.example.loginassessmentapp.UiState

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    var password by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            label = { Text(stringResource(R.string.password)) },
            value = password,
            onValueChange = {
                password = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.resetUiState()
                viewModel.validateLogin(password.trim())

            },
        ) { Text(stringResource(R.string.login_button)) }

        when (uiState) {
            is UiState.None -> {}
            is UiState.Error -> {
                password = ""
                Text(stringResource((uiState as UiState.Error).type.resId))
            }

            is UiState.Success -> {
                navController.navigate(PageRoutes.SecondPage.route)
                viewModel.resetUiState()
            }

        }
    }
}