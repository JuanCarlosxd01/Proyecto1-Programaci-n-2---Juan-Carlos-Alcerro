
package Tablero;

import javax.swing.*;
import java.awt.*;

public abstract class Paneles {
    public Paneles(JPanel panelPrincipal, Color color, Dimension dimension){ 
        GridBagLayout layout = new GridBagLayout();
        JPanel panel = new JPanel(layout);
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(dimension));
    }
}
//panelPrincipal.add(panel, BorderLayout.WEST);
