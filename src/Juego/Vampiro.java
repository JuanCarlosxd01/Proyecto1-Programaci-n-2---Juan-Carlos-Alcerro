
package Juego;

import javax.swing.*;
import java.awt.*;

public class Vampiro extends Pieza{
    
    public Vampiro(){
        super(3, 4 , 5);
        Imagen = new ImageIcon(getClass().getResource("/Imagenes/vampiro.png"));
    }


    public void ataqueEspecial(){
        
    }
}
