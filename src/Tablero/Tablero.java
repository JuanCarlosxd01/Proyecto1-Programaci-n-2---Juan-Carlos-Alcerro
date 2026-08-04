
package Tablero;

import javax.swing.*;
import java.awt.*;

public class Tablero {
    
    public Tablero(JPanel panelPrincipal){
        GridLayout tablero = new GridLayout(6,6);
        JPanel panelCentro = new JPanel(tablero);
        panelCentro.setBackground(Color.BLACK);     
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        crearCasillas(panelCentro, 36);
    }
    
    public int crearCasillas(JPanel panelCentro, int num){
        if(num>0){
            JButton casilla = new JButton();
            casilla.setPreferredSize(new Dimension(150,150));
            panelCentro.add(casilla);
            return crearCasillas(panelCentro, num - 1);
        }
        return 0;
    }
    
    public void crearPieza(){
        
    }
    
}
