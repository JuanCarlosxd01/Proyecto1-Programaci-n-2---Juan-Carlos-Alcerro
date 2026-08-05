
package Juego;

import javax.swing.*;
import java.awt.*;

public class Zombie extends Pieza{
    
    public Zombie(){
        super(1, 1, 0);
        Imagen = new ImageIcon(getClass().getResource("/Imagenes/zombie.png"));
    }


    public void ataqueEspecial(){
        
    }
}
