# GameOfLife
## What I Did:
Made a Game Of Life simulation using a 10x10 grid, using checkboxes bound to a BooleanProperty values to simulate which cells are alive or dead.
The grid itself has a "wrap-around" behaviour such that cells at the edge of the grid are neighbours with cells on the opposite edge; e.g the cell at position (9,9) has neighbours (8,8), (9,8), (0,8), (0,9), (0,0), (9,0), (8,0), and (8,9).

## How to play:
In VSCode, you can run the GameOfLifeApplication main function:
* Tick button will go through one tick of the simulation
* Play button will go through a tick of the simulation every 0.5 seconds
** Play button will turn into Stop button which will stop the simulation at that position

## What I learned:
This was my first time touching upon javafx and how to link UI with code.
* Learned to use Timeline to repeatedly run a function
* Learned BooleanProperty - what it is and why its useful
* Learned more about java - still a new language for me
