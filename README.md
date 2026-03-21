Cat and Mouse Maze Game:
A terminal-based Java game where you play as a mouse trying to collect cheese while avoiding cats.
Demonstrates procedural generation, graph algorithms, and object-oriented design principles.

Technical Highlights:
1. Procedural Maze Generation:
  - The maze is generated at runtime using a randomized Prim's algorithm.
  - After generation, loops are injected by probabilistically removing interior walls that don't create open 2x2 squares.
  - This results in a more natural, less tree-like maze.
  - The generator rejects and rebuilds any maze that fails the following constraints:
    1. All four corners must be reachable from one another.
    2. Every open cel must be reachable from the top left corner.
    3. No open or walled 2x2 squares permitted.

2. Immutable Model Objects:
   - CellLocation and CellState are fully immutable.
   - State changes (e.g. revealing a cell) produce new instances, rather than mutating existing ones.
   - This makes game state transitions explicit, and eliminates a class of bugs around shared mutable states.

3. Cat Movement:
- Each Cat maintains its last move direction, and deprioritizes backtracking by placing the opposite direction last in its candidate list.
- Remaining moves are shuffled randomly, giving the cats organic, non-deterministic movement while still favouring forward exploration.

4. Structural Separation:
The project follows a clean Model / UI separation:
- The Model package owns all game state and logic, with no I/O dependencies.
- MazeTextUI handles all input/output, and drives the game loop.
- MazeGame acts as a facade, exposing a minimal public API to the UI layer.

Project Structure:
MazeGame/
├── Main.java               # Entry point
├── Model/
|   ├── Maze.java           # Procedural generation + constraint validation
|   ├── MazeGame.java       # Game state + public API (facade)
|   ├── Cat.java            # Cat movement
|   ├── CellLocation.java   # Immutable (x, y) coordinate
|   ├── CellState.java      # Immutabe cell data (wall, visibility)
|   ├── MoveDirection.java  # Movement direction enum with inverse lookup
|   ├── PathFinder.java     # Flood-fill connectivity checker
└── TextUI/   
    └── MazeTextUI.java     # Terminal UI and input handling

Gameplay:
- You are @ - a mouse navigating a maze.
- Collect cheese ($) before a cat (!) catches you.
- Gather 5 pieces of cheese to win.
- The maze is only partially visible, and is revealed more as you explore.

Controls:
- W: move up
- A: move left
- S: move down
- D: move right
- ?: show directions
- m: reveal full maze (cheat)
- c: set goal to 1 cheese (cheat)

To run using an IDE like IntelliJ or Eclipse, just run Main.Java.
