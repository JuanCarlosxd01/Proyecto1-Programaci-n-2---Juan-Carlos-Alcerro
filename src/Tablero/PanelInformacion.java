
package Tablero;

import java.awt.*;
import javax.swing.*;

public class PanelInformacion {
    public PanelInformacion(JPanel panelPrincipal){
        GridBagLayout layoutPanelI = new GridBagLayout();
        JPanel panelAbajo = new JPanel(layoutPanelI);
        panelAbajo.setBackground(Color.YELLOW);
        panelAbajo.setPreferredSize(new Dimension(0, 200));
        panelPrincipal.add(panelAbajo, BorderLayout.SOUTH);
    }
    
    
}
