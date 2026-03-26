package com.example.loginassessmentapp

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        context.startActivity(intent)

        device.waitForIdle()
    }

    @Test
    fun mainActivityTest() {
        val passwordField = device.wait(
            Until.findObject(By.text("Password")),
            5000
        )
        passwordField.click()
        device.executeShellCommand("input text Test@2026")

        val loginButton = device.findObject(UiSelector().text("Login"))
        if (!loginButton.exists()) {
            device.pressBack()
        }
        loginButton.click()

        val testText = device.findObject(UiSelector().text("test text 1"))

        if (testText.exists()) {

            val button = device.findObject(UiSelector().text("Test text"))
            button.click()
            val pinField = device.wait(
                Until.findObject(By.text("Pin")),
                5000
            )
            pinField.click()
            device.executeShellCommand("input text 8526")

            device.pressBack()

        } else {
            val button = device.findObject(UiSelector().text("Not test text"))
            button.click()

        }
    }

    @Test
    fun mainActivityTest_whenWrongPasswordEntered_showsError() {
        val passwordField = device.wait(
            Until.findObject(By.text("Password")),
            5000
        )
        passwordField.click()
        device.executeShellCommand("input text wrongPassword")

        val loginButton = device.findObject(UiSelector().text("Login"))
        if (!loginButton.exists()) {
            device.pressBack()
        }
        loginButton.click()

        val errorMessage = device.findObject(UiSelector().text("Please enter the correct password"))
        assert(errorMessage.exists())
    }

    @Test
    fun mainActivityTest_whenNoPasswordEntered_showsError() {
        val passwordField = device.wait(
            Until.findObject(By.text("Password")),
            5000
        )
        passwordField.click()

        val loginButton = device.findObject(UiSelector().text("Login"))
        if (!loginButton.exists()) {
            device.pressBack()
        }
        loginButton.click()

        val errorMessage = device.findObject(UiSelector().text("Please enter the password"))
        assert(errorMessage.exists())
    }
}