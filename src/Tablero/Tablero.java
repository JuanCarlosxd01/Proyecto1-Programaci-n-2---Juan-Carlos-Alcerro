
package Tablero;

import javax.swing.*;
import java.awt.*;

public class Tablero {
    
    public Tablero(JPanel panelPrincipal){
        GridLayout tablero = new GridLayout(6,6);
        JPanel panelCentro = new JPanel(tablero);
        panelCentro.setLayout(tablero);
        panelCentro.setPreferredSize(new Dimension(900,900));
        panelCentro.setBackground(Color.red);
        crearCasillas(panelCentro, 36);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
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
}
