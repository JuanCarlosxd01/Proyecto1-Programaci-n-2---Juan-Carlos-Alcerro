
package Juego;

import Tablero.*;
import javax.swing.*;

public class NuevaPartida {
    
    public NuevaPartida(Tablero tablero, PanelInformacion panelI, PanelHistorial panelH, Ruleta ruleta){
        ruleta.timer(tablero.getCasillas());
        piezasInhabilitadas(tablero.getCasillas(), 5, 5);
        jugador1(tablero, ruleta);
        jugador2(tablero, ruleta);
    }
    
    
    public void jugador1(Tablero tablero, Ruleta ruleta){
        tablero.crearPiezas(tablero.getCasillas(), 0, 0);
        ruleta.girarRuleta();
    }
    
    public void jugador2(Tablero tablero, Ruleta ruleta){
        tablero.crearPiezas(tablero.getCasillas(), 5, 0);
        ruleta.girarRuleta();
    }
    
    public int piezasInhabilitadas(JButton[][] casillas, int fila, int columna){
        if(fila < 0){
            return 0;
        }
        if(columna>= 0){
            casillas[fila][columna].setEnabled(false);
            return piezasInhabilitadas(casillas, fila, columna - 1);
        }
        return piezasInhabilitadas(casillas, fila - 1, 5);
    }
    
}
