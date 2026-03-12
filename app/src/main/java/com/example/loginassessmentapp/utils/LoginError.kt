package com.example.loginassessmentapp.utils

import com.example.loginassessmentapp.R

enum class LoginError(val resId: Int) {
    BLANK_PASSWORD(R.string.blank_password_error),
    WRONG_PASSWORD(R.string.wrong_password_error)
}