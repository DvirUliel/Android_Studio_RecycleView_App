# Back At The Barnyard - Android App

This is an Android application built using Java and Firebase for authentication and real-time database functionality. The app contains features such as user registration, login, data entry, and a RecyclerView that displays a list of characters with their details.

## Features

- **User Authentication**: Users can register and log in using Firebase Authentication.
- **Data Management**: Users can add and retrieve data (like email and phone number) to/from Firebase Realtime Database.
- **RecyclerView**: The app displays a list of characters using a RecyclerView, with each item containing a name, description, and image.
- **Search Functionality**: The list of characters can be filtered using a search bar.

## Technologies Used

- **Android SDK**: The app is built with Android SDK using Java.
- **Firebase**: Firebase Authentication for user registration and login, Firebase Realtime Database for storing and retrieving user data.
- **RecyclerView**: Used to display a list of characters with images, names, and descriptions.

## Project Structure

- **MainActivity.java**: Handles user login and registration, and Firebase interaction.
- **CustomeAdapter.java**: Custom adapter for displaying character data in a RecyclerView.
- **DataArrays.java**: Contains predefined data arrays for characters.
- **DataModel.java**: Defines the data model for each character (name, description, image).
- **Home.java**: Fragment for displaying the home screen with login and registration buttons.
- **RecycleView.java**: Fragment for displaying the list of characters using RecyclerView.
- **Register.java**: Fragment for handling user registration.

## Usage

1. **Registration**: Users need to fill in the email, password, and phone number to register.
2. **Login**: After registration, users can log in using their credentials.
3. **Character List**: After login, the app displays a list of characters, and users can click on any character to see more information.
4. **Search**: Users can search for characters by name.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DvirUliel/Android_Studio_RecycleView_App.git
2. Open the project in Android Studio.
3. Add your Firebase configuration to the app by following these steps:
   - Go to Firebase Console.
   - Create a new project and add your Android app to the project.
   - Download the google-services.json file and place it in the app/ folder of your project.
4. Build and run the app on your Android device or emulator.
