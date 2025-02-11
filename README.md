# Game Project - User Registration & Game System

## Overview
This Java project implements a simple user registration and authentication system along with two games. The system allows users to register, log in, and play games using a game currency system.

## Features
- User Registration
- User Login & Authentication
- Game ID and Password Generation
- "Guess the Number" Game
- "Rock-Paper-Scissors" Game
- Game Coin System
- User Information Retrieval

## Classes & Functions

### 1. `User` Class
Manages user data including:
- `fullName`: Stores the full name of the user.
- `birthday`: Stores the birth date.
- `GameId`: Unique identifier generated from the first name and birth date.
- `password`: Generated using the first name and birth year.
- `gameCoin`: Initial game currency (100 coins per user).
- `show()`: Displays user details.

### 2. `Project` Class
Handles user management and game functionalities.

#### Methods:
- `userVerify(String GameId, String password)`: Authenticates users.
- `getLoginDetails(String full_name, String dob)`: Retrieves user details.
- `login()`: Registers a new user.
- `guessTheNumber(Project s2)`: Implements "Guess the Number" game.
- `game_child(User currlyLoginUse1)`: Handles "Guess the Number" gameplay.
- `game2()`: Implements "Rock-Paper-Scissors" game.
- `show()`: Displays user login details.

## Game Rules

### 1. "Guess the Number" Game
- Users must guess a randomly generated number between 9 and 99 within 5 attempts.
- Hints are provided at different stages.
- Entry fee: 10 game coins.
- Winning prize: 20 game coins.

### 2. "Rock-Paper-Scissors" Game
- A 5-round game against the computer.
- Entry fee: 5 game coins.
- The player with the most round wins is declared the winner.

## Usage
1. Compile the project using:
   ```sh
   javac Project.java
   ```
2. Run the program:
   ```sh
   java Project
   ```
3. Follow the on-screen instructions to register, log in, and play games.

## Future Enhancements
- Implement a database for user storage.
- Improve the UI with a graphical interface.
- Add more games.

## Author
- Developed by Jeet Garala

