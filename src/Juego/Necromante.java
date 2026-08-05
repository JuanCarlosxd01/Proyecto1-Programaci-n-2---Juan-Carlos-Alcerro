
package Juego;

import javax.swing.*;
import java.awt.*;

public class Necromante extends Pieza{
    
    public Necromante(){
        super(4, 3, 1);
        Imagen = new ImageIcon(getClass().getResource("/Imagenes/necromante.png"));
    }
    
    
    public void ataqueEspecial(){
        
    }
}
