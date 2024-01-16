Author: Violet Laing
Date: 10/29/2023

# Nim-Game
Thanks for checking out the game!

Nim instructions:
Start with a pile of marbles. During your turn, you're allowed to:
   Take at least one marble, but take no more than half the pile
Alternate turns with your opponent until there is one marble left.
Whoever takes the last marble loses!

For this project in particular, you may select a difficulty. 
   Enter 1 for easy, 2 for hard.
      Easy will select a random amount of marbles.
      Hard will select an amount of marbles that will help the computer win.

---

# Nim.java

- Contains the main method
- Prompts the user for difficulty
- Creates an object with the difficulty and starts the game

---

# Game.java

- Executes the game linearly
- Calls methods for both the computer's move and the player's move
- Determines the winner

---

# Player.java

- Prompts the user for a move
- Passes the move back to Game

---

# Computer.java

- In easy mode, computer selects a random move
- In smart mode, computer tests for the best move to win
- Passes the move back to Game
