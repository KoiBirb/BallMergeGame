package Main;

import GUI.EndScreen;
import GUI.ScoreBoard;
import GUI.TitleScreen;
import Sound.MusicHandler;

public class Main {

    public static int gameState = 0;
    public final static int SLEEPTIME = 5;
    public static MusicHandler mh = new MusicHandler();
    public static TitleScreen ts = new TitleScreen();
    public static GamePanel gp = new GamePanel();
    public static EndScreen es = new EndScreen();

    public static void main(String[] args) {

        mh.playBackgroundMusic();

        while (true) { //main game loop
           TitleScreen.gc.setVisible(false);
           GamePanel.gc.setVisible(false);
           EndScreen.gc.setVisible(false);

           switch (gameState) { //makes it easy to navigate between menu, game, end
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

           // Update scoreboard
            if (ScoreBoard.score > ScoreBoard.topScores[6]) {
                ScoreBoard.topScores[6] = ScoreBoard.score;
            }
            ScoreBoard.topScores = Sort.mergeSort(ScoreBoard.topScores);

            ScoreBoard.score = 0;
       }
    }
}