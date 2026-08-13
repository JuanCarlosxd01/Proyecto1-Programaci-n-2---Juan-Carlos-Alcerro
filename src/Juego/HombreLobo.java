
package Juego;

import javax.swing.*;
import java.awt.*;

public class HombreLobo extends Pieza{
    private int[][] movimientos = {
         { 1, -1}, { 1, 0}, { 1, 1},
        { 0, -1},           { 0, 1},
        {-1, -1}, {-1, 0}, {-1, 1},

        { 2, -2}, { 2, 0}, { 2, 2},
        { 0, -2},           { 0, 2},
        {-2, -2}, {-2, 0}, {-2, 2}
    };
    JButton[][] casillas;
    
    public HombreLobo(boolean habilitada, int posX, int posY){
        super(5, 5, 2, habilitada, posX, posY);   
    }
    
    public void ataqueEspecial(){
        int[][] casillasAdyacentes = new int[16][2];
        for (int i = 0; i < movimientos.length; i++) {
            casillasAdyacentes[i][0] = movimientos[i][0] + getPosX();
            casillasAdyacentes[i][1] = movimientos[i][1] + getPosY();
        }
        for (int i = 0; i < casillasAdyacentes.length; i++) {
            int filaTemp = casillasAdyacentes[i][0];
            int columnaTemp = casillasAdyacentes[i][1];
            if(filaTemp >= 0 && filaTemp < casillas.length && columnaTemp >= 0 && columnaTemp < casillas.length){
                if(Math.abs(movimientos[i][0]) == 2 || Math.abs(movimientos[i][1]) == 2){
                    int filaIntermedia = getPosX() + movimientos[i][0]/2;
                    int columnaIntermedia = getPosY() + movimientos[i][1]/2;
                    if(casillas[filaIntermedia][columnaIntermedia].getIcon() != null){
                        continue;
                    }
                }
                if(casillas[filaTemp][columnaTemp].getIcon() == null){
                    casillas[filaTemp][columnaTemp].setEnabled(true);
                    casillas[filaTemp][columnaTemp].setOpaque(true);
                    casillas[filaTemp][columnaTemp].setContentAreaFilled(true);
                    casillas[filaTemp][columnaTemp].setBorderPainted(true);
                    casillas[filaTemp][columnaTemp].setBackground(Color.YELLOW);
                }
            }
                
        }
    }  
    
     public void setCasillas(JButton[][] casillas){
        this.casillas = casillas;
    } 
     
     @Override
     public String toString(){
         return "Hombre Lobo";
     }
}
