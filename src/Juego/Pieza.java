
package Juego;


import javax.swing.*;
import java.awt.*;

public abstract class Pieza {
    
    protected final int Ataque;
    protected final int Vida;
    protected final int Escudo;
    ImageIcon Imagen;
    int filaPieza;
    int columnaPieza;
    
    public Pieza(int Ataque, int Vida, int Escudo){
        this.Ataque = Ataque;
        this.Vida = Vida;
        this.Escudo = Escudo;
    }
    
    public void figuraPieza(){
        
    }
    
    public int moverPieza(JButton[][] casillas, int fila, int columna){
        filaPieza = fila;
        columnaPieza = columna;
        
        if(fila < 0){
            return 0;
        }
        if(fila >= 0){
            return moverPieza(casillas, fila, columna - 1);
        }
        return moverPieza(casillas, fila - 1, columna);
    }
    
    public abstract void ataqueEspecial();
    
    
    
    public void recibirAtaque(){
    }
    
    public ImageIcon getImagen(){
        return Imagen;
    }
    
}
