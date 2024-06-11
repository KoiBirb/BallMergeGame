package Main;

import GUI.EndScreen;
import GUI.TitleScreen;
import Sound.MusicHandler;

public class Main {

    public static int gameState = 0;
    public static MusicHandler mh = new MusicHandler();
    public static TitleScreen ts = new TitleScreen();
    public static GamePanel gp = new GamePanel();
    public static EndScreen es = new EndScreen();

    public static void main(String[] args) {

        mh.playBackgroundMusic();

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