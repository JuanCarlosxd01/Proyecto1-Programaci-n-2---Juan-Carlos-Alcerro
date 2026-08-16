
package musica;

import javax.sound.sampled.*;

public class Musica {
    
    private Clip clip;
    private FloatControl controlVolumen;
    
    public Musica(String archivo){
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource("/musica/"+archivo+".wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                controlVolumen = (FloatControl) clip.getControl(
                    FloatControl.Type.MASTER_GAIN
                );
            }
        } catch (Exception e) {
            System.out.println("Error al cargar el sonido: " + archivo);
            e.printStackTrace();
        }
    }
    
    public void reproducir() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void repetir() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void detener() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void pausar() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void setVolumen(float volumen) {
        if (controlVolumen != null) {
            controlVolumen.setValue(volumen);
        }
    }

    public boolean estaSonando() {
        return clip != null && clip.isRunning();
    }
}
