
package Juego;

import javax.swing.*;
import java.awt.*;

public class HombreLobo extends Pieza{
    
    public HombreLobo(){
        super(5, 5, 2);   
        Imagen = new ImageIcon(getClass().getResource("/Imagenes/hombreLobo.png"));
    }
    
    public void ataqueEspecial(){
        
    }
}
