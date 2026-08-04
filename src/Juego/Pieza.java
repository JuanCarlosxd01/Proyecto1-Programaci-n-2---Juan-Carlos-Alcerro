
package Juego;


import javax.swing.*;
import java.awt.*;

public abstract class Pieza {
    
    protected final int Ataque;
    protected final int Vida;
    protected final int Escudo;
    protected final ImageIcon verImagen = new ImageIcon();
    
    public Pieza(int Ataque, int Vida, int Escudo){
        this.Ataque = Ataque;
        this.Vida = Vida;
        this.Escudo = Escudo;
    }
    
    
    public void figuraPieza(){
        
    }
    
    public void moverPieza(){
        
    }
    
    public abstract void ataqueEspecial();
    
    
    
    public void recibirAtaque(){
    }
    
}
