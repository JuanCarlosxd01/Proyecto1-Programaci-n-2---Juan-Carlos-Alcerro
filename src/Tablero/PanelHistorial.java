
package Tablero;

import java.awt.*;
import javax.swing.*;

public class PanelHistorial {
    
    public PanelHistorial(JPanel panelPrincipal){
        GridLayout tablero = new GridLayout(6,6);
        JPanel panelCentro = new JPanel(tablero);
        panelCentro.setLayout(tablero);
        panelCentro.setPreferredSize(new Dimension(400,400));
        panelCentro.setBackground(Color.red);
        crearCasillas(panelCentro, 36);
        panelPrincipal.add(panelCentro, BorderLayout.EAST);
    }
    
    public int crearCasillas(JPanel panelCentro, int num){
        if(num>0){
            JButton casilla = new JButton();
            casilla.setPreferredSize(new Dimension(80,80));
            panelCentro.add(casilla);
            return crearCasillas(panelCentro, num - 1);
        }
        return 0;
    }
}
