
**Android Login App**

A simple Android application built with Jetpack Compose demonstrating a login workflow, navigation between multiple screens, and automated UI testing using UI Automator.

This project showcases modern Android development practices including MVVM architecture, Compose Navigation, and instrumentation testing.


**Features**

- Login screen with password validation
- Navigation across three screens
- Numeric-only PIN input field
- MVVM architecture using ViewModel
- Jetpack Compose UI
- UI Automator end-to-end automation tests

**Application Flow**

**1. Login Page**
- User enters a password
- Password validation handled by LoginViewModel
- Correct password: Test@2026

**2. Second Page**
Displays the text: test text 1

Two buttons are available:

- **Test text** → Navigates to the PIN screen
- **Not test text** → Exits the application

**3. Third Page**

- Numeric input field
- Only digits are accepted
- Example PIN used in automation tests: 8526

**Tech Stack**

- Kotlin
- Jetpack Compose
- Navigation Compose
- Android ViewModel (MVVM)
- UI Automator

**UI Automator Test**

The project includes a UI Automator instrumentation test that validates the full user flow.

**Testing Steps**

1. Launch the application
2. Enter password Test@2026
3. Click Login button
4. Verify the text "test text 1"
5. Click Test text
6. Enter PIN 

**Generating the Instrumentation APK**

./gradlew assembleDebug assembleDebugAndroidTest

Generated files:

app/build/outputs/apk/debug/app-debug.apk
app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk

**Installing APKs**

Install both APKs on a device or emulator:

adb install app/build/outputs/apk/debug/app-debug.apk
adb install app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk

**Running Tests**

Run instrumentation tests using:

./gradlew connectedAndroidTest

or

adb shell am instrument -w com.example.androidloginapp.test/androidx.test.runner.AndroidJUnitRunner

**Running the App**

1. Clone the repository

git clone https://github.com/yourusername/android-login-app.git

2. Open the project in Android Studio

3. Run the application on an emulator or Android device

**Notes**

- Navigation implemented using Jetpack Compose Navigation
- UI state managed using ViewModel and StateFlow
- Input validation handled in the ViewModel
- UI Automator used for end-to-end testing
