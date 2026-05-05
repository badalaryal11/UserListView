# User List Viewer (Kotlin + MVVM)

Android application built for the Junior Android Developer technical task.

## Features
- Fetches user list from `https://jsonplaceholder.typicode.com/users`
- User list screen displays:
  - Name
  - Email
  - City
- User detail screen displays:
  - Full Name
  - Email
  - Phone
  - Company Name
- Loading state while API request is in progress
- Error state with retry action
- MVVM architecture with Repository and API service layer

## Tech Stack
- Kotlin
- Jetpack Compose
- MVVM
- Retrofit + Gson
- Kotlin Coroutines
- Navigation Compose

## Architecture
- **View**: `MainActivity`, `UserListScreen`, `UserDetailScreen`
- **ViewModel**: `UserViewModel`
- **Repository**: `UserRepository`
- **API Layer**: `ApiService`, `RetrofitClient`

## Project Structure
- `app/src/main/java/com/example/userlistviewer/data/model` - API data models
- `app/src/main/java/com/example/userlistviewer/data/remote` - Retrofit API setup
- `app/src/main/java/com/example/userlistviewer/data/repository` - Repository
- `app/src/main/java/com/example/userlistviewer/ui/viewmodel` - ViewModel + UI state
- `app/src/main/java/com/example/userlistviewer/ui/screen` - Compose screens
- `app/src/main/java/com/example/userlistviewer/ui/navigation` - Navigation destinations

## Setup Instructions
1. Open the project in Android Studio (Hedgehog+ / Jellyfish+).
2. Ensure Android SDK 34 is installed.
3. Let Gradle sync dependencies.
4. Run the app on emulator or physical device.

## Build Debug APK
From project root:

```bash
./gradlew assembleDebug
```

APK output path:
`app/build/outputs/apk/debug/app-debug.apk`

## Assumptions / Limitations
- Detail screen uses the already-fetched list data; if app state is lost before data loads, detail may show "User not found".
- No offline caching (Room) implemented.
- Search/filter and pull-to-refresh are not included in this base submission.
