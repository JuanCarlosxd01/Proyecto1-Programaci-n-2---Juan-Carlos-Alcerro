
package Juego;


public abstract class Pieza {
    
    protected final int Ataque;
    protected final int Vida;
    protected final int Escudo;
    
    public Pieza(int Ataque, int Vida, int Escudow){
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
