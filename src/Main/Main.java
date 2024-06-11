package Main;

import GUI.EndScreen;
import GUI.TitleScreen;

public class Main {

    public static int gameState = 0;
    public static TitleScreen ts = new TitleScreen();
    public static GamePanel gp = new GamePanel();
    public static EndScreen es = new EndScreen();

    public static void main(String[] args) {
        // Create a new GamePanel object and start the game
       while (true) {

           TitleScreen.gc.setVisible(false);
           GamePanel.gc.setVisible(false);
           EndScreen.gc.setVisible(false);

           switch (gameState) {
               case 0:
                   TitleScreen.gc.setVisible(true);
                   ts.start();
                   break;
               case 1:
                   GamePanel.gc.setVisible(true);
                   gp.start();
                   break;
               case 2:
                   EndScreen.gc.setVisible(true);
                   es.start();
                   break;
           }
       }
    }
}