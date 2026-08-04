
package Tablero;

import java.awt.*;
import javax.swing.*;
import Menus.*;


public class ventanaTablero extends JPanel{
    
    JPanel panelPrincipal;
    BorderLayout border;
    
    public ventanaTablero(VentanaPrincipal ventana){
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        border = new BorderLayout();
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(border);

        Tablero tablero = new Tablero(panelPrincipal);
        PanelInformacion panelI = new PanelInformacion(panelPrincipal);
        PanelHistorial panelH = new PanelHistorial(panelPrincipal);
        Ruleta ruleta = new Ruleta(panelPrincipal);
        
        ventana.getContentPane().removeAll();
        ventana.add(panelPrincipal);
        ventana.revalidate();
        ventana.repaint();
    }
}
