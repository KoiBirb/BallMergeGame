/**
 * MusicHandler.java
 * Mariana Trillos
 * June 12, 2024
 * Dictates when to play each sound
 */
package Sound;
import Main.GamePanel;

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
    }

    /**
    * Plays background music
     */
    public void playBackgroundMusic(){
        playMusic(0);
    }

    /**
     * Plays bomb sound effect
     */
    public void playEndSoundEffect(){
        playSoundEffect(1);
    }

    public void playHelpSoundEffect(boolean up){
        if (up) playSoundEffect(3);
        else playSoundEffect(2);
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
     * @param i int number of file path
     */
    private void playSoundEffect(int i) {
        effect.setFile(i);
        effect.play();
    }

}
