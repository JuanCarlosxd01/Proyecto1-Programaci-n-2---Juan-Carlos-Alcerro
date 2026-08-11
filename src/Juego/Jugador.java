
package Juego;

import Menus.*;
import Tablero.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Jugador {
    
    private Usuario usuario;
    private boolean turno;
    private ArrayList<Pieza> piezas = new ArrayList<>();
    
    public Jugador(Usuario usuario, boolean turno, Color color, int filaInicial){
        this.turno = turno;
        this.usuario = usuario;

        piezas.add(new HombreLobo(true, filaInicial,0));
        piezas.add(new Vampiro(true, filaInicial, 1));
        piezas.add(new Necromante(true, filaInicial, 2));  
        piezas.add(new Necromante(true, filaInicial, 3));
        piezas.add(new Vampiro(true, filaInicial, 4)); 
        piezas.add(new HombreLobo(true, filaInicial, 5));
    }
    
    public boolean getTurno(){
        return turno;
    }
    
    public void setTurno(boolean turno){
        this.turno = turno;
    }
    
    
    public Pieza getPieza(int indice){
        return piezas.get(indice);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }
    
}
