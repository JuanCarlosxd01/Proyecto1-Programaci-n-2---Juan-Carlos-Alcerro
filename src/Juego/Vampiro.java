
package Juego;

public class Vampiro extends Pieza{
    
    private Partida partida = null;
    
    public Vampiro(boolean habilitada, int posX, int posY){
        super(3, 4 , 5, habilitada, posX, posY);
    }


    public void ataqueEspecial(){
        Ataque = 1;
        partida.hacerAtaque(partida.filaTemp, partida.columnaTemp, partida.numPieza);
        Vida ++;
        Ataque = 3;
    }
    
    public void setPartida(Partida partida){
        this.partida = partida;
    }
}
