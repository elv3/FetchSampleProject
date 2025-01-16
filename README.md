# Fetch Rewards Coding Exercise - Software Engineering - Mobile

## Overview

This project is a native Android application developed in Kotlin, aimed at fetching and displaying data from Fetch Rewards. It highlights the seamless integration of fragments with Jetpack Compose, adhering to clean architecture principles through the MVVM (Model-View-ViewModel) pattern. The app also features dependency injection and minimal data binding to ensure a robust, modular, and maintainable design.

## Features

- Fetches and displays data from the provided JSON endpoint.
- Groups items by `listId`.
- Sorts items first by `listId` and then by `name`.
- Filters out items where the `name` is blank or null.
- Displays the results in an easy-to-read list format.
- Demonstrates the use of both Fragments and Jetpack Compose together.
- Follows Clean Architecture with MVVM design pattern.
- Implements Dependency Injection.
- Uses minimal Data Binding.

## Project Setup

### Installation

    1. Clone this repository:
        git clone https://github.com/your-username/fetch-rewards-exercise.git
    2. Open the project in Android Studio.
    3. Sync the project with Gradle files.
    4. Run the app on an emulator or a physical device running Android.

## The app will:

    1. Retrieve data from the JSON endpoint.
    2. Display the data grouped by listId in ascending order.
    3. Sort the items within each group by name.
    4. Filter out any items with blank or null name values.

## Architecture

This project follows the Clean Architecture approach with the MVVM (Model-View-ViewModel) pattern. Key components include:

   ViewModel: Handles UI-related data and logic, fetching data from the repository.
   Repository: Manages data operations and serves as a single source of truth for the app's data.
   UI Layer: Comprises Fragments and Jetpack Compose elements to display the data in a user-friendly way.

## Dependencies

- Jetpack Compose
- Fragments
- Dependency Injection (Hilt)
- Retrofit for network requests
- Coroutines for asynchronous operations
- Data Binding


## License

This project is licensed under the MIT License

## Contact

For questions or further information, please contact [avalen3000@gmail.com].

## Notes
The project is designed to be buildable on the latest stable tools and supports the current release of the Android OS.