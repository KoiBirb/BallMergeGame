package Main;

import GUI.EndScreen;
import GUI.TitleScreen;

public class Main {

    public static int gameState = 0;

    public static void main(String[] args) {
        // Create a new GamePanel object and start the game
       while (true) {
           switch (gameState) {
               case 0:
                   TitleScreen ts = new TitleScreen();
                   ts.start();
                   break;
               case 1:
                   GamePanel gp = new GamePanel();
                   gp.start();
                   break;

               case 2:
                   EndScreen es = new EndScreen();
                   es.start();
           }
       }
    }
}