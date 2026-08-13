
package Tablero;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class PanelInformacion extends JPanel{
    
    Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelInformacion.jpeg")).getImage();
    
    public PanelInformacion(JPanel panelPrincipal){ 
        GridBagLayout layoutPanelI = new GridBagLayout();
        setLayout(layoutPanelI);        
        setPreferredSize(new Dimension(0, 200));
        panelPrincipal.add(this, BorderLayout.SOUTH);
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
    
    
}
