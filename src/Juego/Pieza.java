
package Juego;


import javax.swing.*;
import java.awt.*;

public abstract class Pieza {
    
    protected int Ataque;
    protected int Vida;
    protected int Escudo;
    boolean habilitada = false;
    private int posX;
    private int posY;
    
    public Pieza(int Ataque, int Vida, int Escudo, boolean habilitada, int posX, int posY){
        this.Ataque = Ataque;
        this.Vida = Vida;
        this.Escudo = Escudo;
        this.habilitada = habilitada;
        this.posX = posX;
        this.posY = posY;
        
    }
    
    
    public abstract void ataqueEspecial();
    
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public void setPosX(int posX){
        this.posX = posX;
    }
    
    public void setPosY(int posY){
        this.posY = posY;
    }
    
    public int getAtaque(){
        return Ataque;
    }
    
    public int getVida(){
        return Vida;
    }
    
    public int getEscudo(){
        return Escudo;
    }
    
    public boolean getHabilitada(){
        return habilitada;
    }
    
    public void setVida(int Vida){
        this.Vida = Vida;
    }
    
    public void setEscudo(int Escudo){
        this.Escudo = Escudo;
    }
    
    public void setHabilitada(boolean habilitada){
        this.habilitada = habilitada;
    }      
    
}
