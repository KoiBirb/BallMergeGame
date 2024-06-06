package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public sound() {

        soundURL[0] = getClass().getResource("/sound/background_music_1.wav");
        soundURL[1] = getClass().getResource("/sound/background_music_2.wav");
        soundURL[2] = getClass().getResource("/sound/background_music_3.wav");
        soundURL[3] = getClass().getResource("/sound/battle_music_1.wav");
        soundURL[4] = getClass().getResource("/sound/battle_music_1.wav");
        soundURL[5] = getClass().getResource("/sound/key_collect.wav");
    }
    public void setFile(int i){

        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){

        }
    }
    public void play(){

        clip.start();
    }

    public void loop(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){

        clip.stop();
    }
}
