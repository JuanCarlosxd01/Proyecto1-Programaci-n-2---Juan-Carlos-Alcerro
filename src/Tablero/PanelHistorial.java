
package Tablero;

import java.awt.*;
import javax.swing.*;

public class PanelHistorial {
    
    public PanelHistorial(JPanel panelPrincipal){
        GridBagLayout layoutPanelH = new GridBagLayout();
        JPanel panelDerecha = new JPanel(layoutPanelH);
        panelDerecha.setBackground(Color.ORANGE);
        panelDerecha.setPreferredSize(new Dimension(288, 0));
        panelPrincipal.add(panelDerecha, BorderLayout.EAST);
    }
    
    
}
