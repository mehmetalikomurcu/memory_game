Overview

The game is designed to challenge players' memory by having them match pairs of colors hidden on a 4x4 grid. The game tracks the time taken to complete the matching process and provides feedback when all pairs have been successfully matched.

Features

    Randomized Game Board: Each game generates a new 4x4 grid with randomly placed color pairs.
    Simple User Interface: The game uses JFrame for the window and Graphics for rendering the game board and colors.
    Time Tracking: The game measures how long it takes for the player to match all pairs and displays this information at the end of the game.
    Error Handling: The game includes logic to prevent issues such as clicking the same square twice or interacting with already matched pairs.

Gameplay Instructions

    Start the Game: Upon starting, the game displays a 4x4 grid with hidden colors.
    Select a Square: Click on any black square to reveal the color underneath.
    Match Colors: Try to find and match pairs of the same color. When two matching squares are found, they remain visible.
    Game End: The game concludes when all pairs are matched. A message will display the total time taken to complete the game.
    Exit: Click “OK” in the completion message to close the game. You can also exit anytime by clicking the “X” button in the window.

Possible Improvements

    Time Constraints: Introduce a countdown timer, challenging the player to complete the game within a set time limit.
    Memory Preview: Show the entire board briefly at the start of the game to increase the challenge.
    Dynamic Board Sizes: Expand the game to support larger grids, such as 6x6 or 10x10, making the code more dynamic and scalable.

Known Issues

    The algorithm is not fully optimized for larger grid sizes due to the initial use of static if statements.
    Fast consecutive clicks may lead to incorrect results due to timing issues in the current implementation.