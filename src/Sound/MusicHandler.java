package Sound;

import Main.GamePanel;

import static GUI.TitleScreen.gc;
import static GUI.TitleScreen.help;

public class MusicHandler {

    sound music = new sound();
    sound effect = new sound();
    public boolean playDrop = false;

    public void update(){

        try {
            if (playDrop && GamePanel.fruits.get(GamePanel.fruits.size() - 1).isDropped) {
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

    public void playBackgroundMusic(){
        playMusic(0);
    }

    public void playEndSoundEffect(){
        playMusic(1);
    }


    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    private void playSoundEffect(int i) {
        effect.setFile(i);
        effect.play();
    }

}
