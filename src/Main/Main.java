package Main;

import GUI.TitleScreen;

public class Main {
    public static void main(String[] args) {
        // Create a new GamePanel object and start the game
        TitleScreen ts = new TitleScreen();
        if (ts.start()) {
            GamePanel gp = new GamePanel();
            gp.start();
        }
    }
}