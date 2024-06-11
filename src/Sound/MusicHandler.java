/**
 * MusicHandler.java
 * Mariana Trillos
 * June 12, 2024
 * Dictates when to play each sound
 */
package Sound;
import Main.GamePanel;
import static GUI.TitleScreen.gc;
import static GUI.TitleScreen.help;

public class MusicHandler {

    //import necessary objects
    sound music = new sound();
    sound effect = new sound();

    /**
     * Checks if fruit are dropped or help, plays correct sound effect from array
     */
    public void update(){

        try {
            if (GamePanel.fruits.get(GamePanel.fruits.size() - 1).isDropped) {
                playSoundEffect(4);
            }
        } catch (IndexOutOfBoundsException ignored){}

        if (help.contains(gc.getMouseX(), gc.getMouseY())){
            playSoundEffect(3);
            if(!help.contains(gc.getMouseX(), gc.getMouseY())){
                playSoundEffect(2);
            }
        }
    }

    /**
    * Plays background music
     */
    public void playBackgroundMusic(){
        playMusic(0);
    }

    /**
     * When loss: plays bomb sound effect
     */
    public void playEndSoundEffect(){
        playSoundEffect(1);
    }


    /**
     * Plays the background music on a loop
     * @param i music file to play
     */
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    /**
     * Plays specified sound effect
     * @param i
     */
    private void playSoundEffect(int i) {
        effect.setFile(i);
        effect.play();
    }

}
