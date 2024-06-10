package Sound;

import Main.GamePanel;

import static GUI.TitleScreen.gc;
import static GUI.TitleScreen.help;

public class MusicHandler {

    sound music = new sound();
    sound effect = new sound();
    public boolean playMerge = false;

    public MusicHandler(){
        playMusic(0);
    }

    public void update(){

        if (playMerge && GamePanel.fruits.get(GamePanel.fruits.size() - 1).isDropped) {
            playSoundEffect(4);
        }

        if (help.contains(gc.getMouseX(), gc.getMouseY())){
            playSoundEffect(3);
            if(!help.contains(gc.getMouseX(), gc.getMouseY())){
                playSoundEffect(2);
            }
        }
        if(false){
            music.stop();
            playSoundEffect(1);
        }
    }


    private void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    private void stopMusic(){
        music.stop();
    }

    private void playSoundEffect(int i) {
        effect.setFile(i);
        effect.play();
    }

}
