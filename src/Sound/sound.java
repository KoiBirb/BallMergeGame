/**
 * Sound.java
 * Leo Bogaert
 * June 12, 2024
 * Creates sound object
 */
package Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class sound {

    Clip clip;
    URL soundArray[] = new URL[5];

    /**
     * Creates an array that stores all the sound effects
     */
    public sound() {

        soundArray[0] = getClass().getResource("/sound/backgroundMusic.wav");
        soundArray[1] = getClass().getResource("/sound/BombSound.wav");
        soundArray[2] = getClass().getResource("/sound/chimeDown.wav");
        soundArray[3] = getClass().getResource("/sound/chimeUp.wav");
        soundArray[4] = getClass().getResource("/sound/mergeSound.wav");
    }

    /**
     * Sets song file path
     * @param i integer value of song file path in array
     */
    public void setFile(int i){

        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundArray[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){
            System.out.println("Error loading sound, File number: " + i);
        }
    }

    /**
     * Starts playing
     */
    public void play(){
        clip.start();
    }

    /**
     * Loops the background music
     */
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
