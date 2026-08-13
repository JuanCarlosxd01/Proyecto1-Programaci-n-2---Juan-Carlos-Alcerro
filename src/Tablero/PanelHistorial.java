
package Tablero;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PanelHistorial extends JPanel{
    
    Image fondo = new ImageIcon(getClass().getResource("/Imagenes/PanelHistorial.jpeg")).getImage();
    private JTextArea historial;
    private JScrollPane scroll;
    int cont = 1;
    
    public PanelHistorial(JPanel panelPrincipal){
        historial = new JTextArea();
        historial.setOpaque(false);
        historial.setEditable(false);
        historial.setFocusable(false);
        cambiarFuente();
        scroll = new JScrollPane(historial);
        
        scroll.setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));
        scroll.getViewport().setOpaque(false);
        scroll.setPreferredSize(new Dimension(this.getWidth() - 50, this.getHeight() - 50));
        scroll.setMaximumSize(new Dimension(this.getWidth() - 50, this.getHeight() - 50));
        historial.append(cont + ". ⚔️ ¡La batalla ha comenzado! ⚔️.  \n \n");
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        setPreferredSize(new Dimension(288, 0));
        panelPrincipal.add(this, BorderLayout.EAST);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
    
    private void cambiarFuente(){
        historial.setFont(new Font("Serif", Font.BOLD, 14));
        historial.setForeground(Color.WHITE);
        historial.setLineWrap(true);
        historial.setWrapStyleWord(true);
        historial.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    public void agregarMovimiento(String movimiento){
        historial.append((cont += 1) + ". " + movimiento + "\n \n");
    }
    
}
