
package Juego;

import Menus.*;
import Tablero.*;
import javax.swing.*;
import java.awt.*;

public class Jugador {
    
    private Usuario usuario;
    private boolean turno;
    private Pieza[] piezas = new Pieza[6];
    
    public Jugador(Usuario usuario, boolean turno, Color color, int filaInicial){
        this.turno = turno;
        this.usuario = usuario;

        piezas[0] = new HombreLobo(true, filaInicial,0);
        piezas[1] = new Vampiro(true, filaInicial, 1);
        piezas[2] = new Necromante(true, filaInicial, 2);  
        piezas[3] = new Necromante(true, filaInicial, 3);
        piezas[4] = new Vampiro(true, filaInicial, 4); 
        piezas[5] = new HombreLobo(true, filaInicial, 5);
    }
    
    public boolean getTurno(){
        return turno;
    }
    
    public void setTurno(boolean turno){
        this.turno = turno;
    }
    
    
    public Pieza getPieza(int indice){
        return piezas[indice];
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
