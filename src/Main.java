import Model.MazeGame;
import TextUI.MazeTextUI;

/**
 * Launch the Maze Game with a text UI.
 */
public class Main {
    public static void main(String[] args) {
        MazeGame game = new MazeGame();
        MazeTextUI ui = new MazeTextUI(game);
        ui.playGame();
    }
}

