
package Tablero;

import java.awt.*;
import javax.swing.*;

public class PanelHistorial extends JPanel{
    
    Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelHistorial.jpeg")).getImage();
    
    public PanelHistorial(JPanel panelPrincipal){
        GridBagLayout layoutPanelH = new GridBagLayout();
        setPreferredSize(new Dimension(288, 0));
        panelPrincipal.add(this, BorderLayout.EAST);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
    
    
}
